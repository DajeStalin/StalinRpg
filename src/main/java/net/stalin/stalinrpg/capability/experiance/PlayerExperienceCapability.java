package net.stalin.stalinrpg.capability.experiance;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.fml.network.PacketDistributor;
import net.stalin.stalinrpg.StalinRpg;
import net.stalin.stalinrpg.network.handler.PlayerExperienceClientServerHandler;
import net.stalin.stalinrpg.init.ModNetwork;

import java.util.Objects;

import static net.minecraft.entity.ai.attributes.Attributes.MAX_HEALTH;

public class PlayerExperienceCapability implements IBaseExperienceCapability{

    protected int currentLevel = 0;
    protected int experience = 0;
    protected int levelchange = 300;
    protected int strength;
    protected int points;
    protected int betterPoints;
    protected int choice_class;


    @Override
    public int getCurrentLevel() {
        return currentLevel;
    }

    @Override
    public int getExperience() {
        return experience;
    }

    @Override
    public int getLevelChange() {
        return levelchange;
    }

    @Override
    public int getStrength() {
        return strength;
    }

    @Override
    public int getPoints() {
        return points;
    }

    @Override
    public int getBetterPoints() {
        return betterPoints;
    }

    @Override
    public int getChoiceClass() {
        return choice_class;
    }

    @Override
    public void setMaxHealth(float health, float maxHealth, PlayerEntity pe) {
        Objects.requireNonNull(((LivingEntity) pe).getAttribute(MAX_HEALTH)).setBaseValue(maxHealth + health);
        if (!pe.level.isClientSide)
            sendExperienceChangesToClient((ServerPlayerEntity) pe);
        else
            sendExperienceChangesToServer();
    }

    @Override
    public void setStrength(int strength, PlayerEntity pe) {
        this.strength = strength;
        if (!pe.level.isClientSide)
            sendExperienceChangesToClient((ServerPlayerEntity) pe);
        else
            sendExperienceChangesToServer();
    }

    @Override
    public void setCurrentLevel(int currentLevel, PlayerEntity pe) {
        this.currentLevel = currentLevel;
        if (!pe.level.isClientSide)
            sendExperienceChangesToClient((ServerPlayerEntity) pe);
        else
            sendExperienceChangesToServer();
    }

    @Override
    public void setExperience(int experience, PlayerEntity pe) {
        this.experience = experience;
        if (!pe.level.isClientSide)
            sendExperienceChangesToClient((ServerPlayerEntity) pe);
        else
            sendExperienceChangesToServer();
    }

    @Override
    public void setLevelChange(int levelchange, PlayerEntity pe) {
        this.levelchange = levelchange * currentLevel;
        if (!pe.level.isClientSide)
            sendExperienceChangesToClient((ServerPlayerEntity) pe);
        else
            sendExperienceChangesToServer();
    }

    @Override
    public void setPoints(int points, PlayerEntity pe) {
        this.points = points;
        if (!pe.level.isClientSide)
            sendExperienceChangesToClient((ServerPlayerEntity) pe);
        else
            sendExperienceChangesToServer();
    }

    @Override
    public void setBetterPoints(int betterPoints, PlayerEntity pe) {
        this.betterPoints = betterPoints;
        if (!pe.level.isClientSide)
            sendExperienceChangesToClient((ServerPlayerEntity) pe);
        else
            sendExperienceChangesToServer();
    }

    @Override
    public void addLevel(int currentLevel, PlayerEntity pe) {
        this.currentLevel += currentLevel;
        if (!pe.level.isClientSide)
            sendExperienceChangesToClient((ServerPlayerEntity) pe);
        else
            sendExperienceChangesToServer();
    }

    @Override
    public void addExperience(int experience, PlayerEntity pe) {
        this.experience += experience;
        if (!pe.level.isClientSide)
            sendExperienceChangesToClient((ServerPlayerEntity) pe);
        else
            sendExperienceChangesToServer();
    }

    @Override
    public void setClassWarrior(PlayerEntity pe) {
        this.choice_class = 1;
        if (!pe.level.isClientSide)
            sendExperienceChangesToClient((ServerPlayerEntity) pe);
        else
            sendExperienceChangesToServer();
    }

    @Override
    public void setClassRogue(PlayerEntity pe) {
        this.choice_class = 2;
        if (!pe.level.isClientSide)
            sendExperienceChangesToClient((ServerPlayerEntity) pe);
        else
            sendExperienceChangesToServer();
    }

    @Override
    public void setClassMage(PlayerEntity pe) {
        this.choice_class = 3;
        if (!pe.level.isClientSide)
            sendExperienceChangesToClient((ServerPlayerEntity) pe);
        else
            sendExperienceChangesToServer();
    }

    @Override
    public void addStrength(int strength, PlayerEntity pe) {
        this.strength += strength;
        if (!pe.level.isClientSide)
            sendExperienceChangesToClient((ServerPlayerEntity) pe);
        else
            sendExperienceChangesToServer();
    }

    @Override
    public void addPoints(int points, PlayerEntity pe) {
        this.points += points;
        if (!pe.level.isClientSide)
            sendExperienceChangesToClient((ServerPlayerEntity) pe);
        else
            sendExperienceChangesToServer();
    }

    @Override
    public void addBetterPoints(int betterPoints, PlayerEntity pe) {
        this.betterPoints += betterPoints;
        if (!pe.level.isClientSide)
            sendExperienceChangesToClient((ServerPlayerEntity) pe);
        else
            sendExperienceChangesToServer();
    }

    @Override
    public void removeStrength(int strength, PlayerEntity pe) {
        this.strength -= strength;
        if (!pe.level.isClientSide)
            sendExperienceChangesToClient((ServerPlayerEntity) pe);
        else
            sendExperienceChangesToServer();
    }

    @Override
    public void removePoints(int points, PlayerEntity pe) {
        this.points -= points;
        if (!pe.level.isClientSide)
            sendExperienceChangesToClient((ServerPlayerEntity) pe);
        else
            sendExperienceChangesToServer();
    }

    @Override
    public void removeBetterPoints(int betterPoints, PlayerEntity pe) {
        this.betterPoints -= betterPoints;
        if (!pe.level.isClientSide)
            sendExperienceChangesToClient((ServerPlayerEntity) pe);
        else
            sendExperienceChangesToServer();
    }

    @Override
    public CompoundNBT getNBTData() {
        CompoundNBT nbt = new CompoundNBT();
        nbt.putInt("currentLevel", currentLevel);
        nbt.putInt("experience", experience);
        nbt.putInt("levelchange", levelchange);
        nbt.putInt("strength", strength);
        nbt.putInt("points", points);
        nbt.putInt("betterPoints", betterPoints);
        nbt.putInt("choice_class", choice_class);
        return nbt;
    }

    @Override
    public void setNBTData(CompoundNBT compound) {
        currentLevel = compound.getInt("currentLevel");
        experience = compound.getInt("experience");
        levelchange = compound.getInt("levelchange");
        strength = compound.getInt("strength");
        points = compound.getInt("points");
        betterPoints = compound.getInt("betterPoints");
        choice_class = compound.getInt("choice_class");
    }

    private void sendExperienceChangesToServer() {
        ModNetwork.CHANNEL.sendToServer(new PlayerExperienceClientServerHandler(getNBTData()));
    }

    private void sendExperienceChangesToClient(ServerPlayerEntity pe) {
//        StalinRpg.LOGGER.info("----------> sendExperienceChangesToClient. Current level: " + currentLevel);
//        StalinRpg.LOGGER.info("----------> sendExperienceChangesToClient. Current experience: " + experience);
//        StalinRpg.LOGGER.info("----------> sendExperienceChangesToClient. Current levelchange: " + levelchange);
        StalinRpg.LOGGER.info("----------> sendExperienceChangesToClient. Current strength: " + strength);
        StalinRpg.LOGGER.info("----------> sendExperienceChangesToClient. Current points: " + points);
        StalinRpg.LOGGER.info("----------> sendExperienceChangesToClient. Current betterPoints: " + betterPoints);
        StalinRpg.LOGGER.info("----------> sendExperienceChangesToClient. Current class: " + choice_class);
        ModNetwork.CHANNEL.send(PacketDistributor.PLAYER.with(() -> pe),
                new PlayerExperienceClientServerHandler(getNBTData()));

    }
}
