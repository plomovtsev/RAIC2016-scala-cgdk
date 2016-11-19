package model

/**
 * Класс, определяющий приспешника волшебника одной из фракций. Содержит также все свойства живого юнита.
 * <p>
 * Миньоны, оставшиеся по той или иной причине без хозяина, часто объединяются в небольшие группы и селятся в лесах.
 * Они крайне настороженно относятся ко всем другим волшебникам и их миньонам.
 * @param type Возвращает тип миньона.
 * @param visionRange Возвращает максимальное расстояние (от центра до центра),
 *                    на котором данный миньон обнаруживает другие объекты.
 * @param damage Возвращает урон одной атаки.
 * @param cooldownTicks Возвращает интервал между атаками.
 * @param remainingActionCooldownTicks Возвращает количество тиков, оставшееся до следующей атаки.
 */
class Minion(id: Long,
             x: Double,
             y: Double,
             speedX: Double,
             speedY: Double,
             angle: Double,
             faction: Faction,
             radius: Double,
             life: Int,
             maxLife: Int,
             statuses: Array[Status],
             val `type`: MinionType,
             val visionRange: Double,
             val damage: Int,
             val cooldownTicks: Int,
             val remainingActionCooldownTicks: Int) extends LivingUnit(id, x, y, speedX, speedY, angle, faction, radius, life, maxLife, statuses)
