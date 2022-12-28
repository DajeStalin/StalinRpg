package net.stalin.stalinrpg.capability.experiance;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.stalin.stalinrpg.capability.IGenericCapability;

public interface IBaseExperienceCapability extends IGenericCapability {
    /*Основные атрибуты игрока*/
    public int getCurrentLevel();
    public int getExperience();
    public int getLevelChange();
    public void setCurrentLevel(int currentLevel, PlayerEntity pe);
    public void setExperience(int experience, PlayerEntity pe);
    public void setLevelChange(int levelchange, PlayerEntity pe);
    public void addLevel(int currentLevel, PlayerEntity pe);
    public void addExperience(int experience, PlayerEntity pe);

    /*Классы*/
    public int getChoiceClass();
    public void setClassWarrior(PlayerEntity pe);
    /*
    * Больше ХП
    * Больше мили дамага
    * Не много больше брони, но меньше мув спид
    */
    public void setClassRogue(PlayerEntity pe);
    /*
    * Больше скорости атаки
    * Больше мув спида
    * Не много меньше армора
    */
    public void setClassMage(PlayerEntity pe);
    /*
    * Маг дамаг(В разработке)
    * Больше маны
    */

    /*Выдача атрибутов*/
    public void setMaxHealth(float health, float maxHealth , PlayerEntity pe);
//    public void setMaxKnockBackResistance(float addResist, float maxResist, PlayerEntity pe);

    /*Поинты*/
    public int getPoints();
    public void setPoints(int points, PlayerEntity pe);
    public void addPoints(int points, PlayerEntity pe);
    public void removePoints(int points, PlayerEntity pe);
    public int getBetterPoints();
    public void setBetterPoints(int betterPoints, PlayerEntity pe);
    public void addBetterPoints(int betterPoints, PlayerEntity pe);
    public void removeBetterPoints(int betterPoints, PlayerEntity pe);

    /*Статы*/
    // Сила
    public int getStrength();
    public void setStrength(int strength, PlayerEntity pe);
    public void addStrength(int strength, PlayerEntity pe);
    public void removeStrength(int strength, PlayerEntity pe);

    CompoundNBT getNBTData();
    public void setNBTData(CompoundNBT nbt);
}
