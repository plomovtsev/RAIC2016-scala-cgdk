package model

/**
 * Класс, определяющий строение. Фракционные строения самостоятельно атакуют противников в определённом радиусе.
 * <p>
 * Строения не могут быть заморожены ({@code FROZEN}).
 * @param type Возвращает тип строения.
 * @param visionRange Возвращает максимальное расстояние (от центра до центра),
 *                    на котором данное строение обнаруживает другие объекты.
 * @param attackRange Возвращает максимальное расстояние (от центра до центра),
 *                    на котором данное строение может атаковать другие объекты.
 * @param damage Возвращает урон одной атаки.
 * @param cooldownTicks Возвращает интервал между атаками.
 * @param remainingActionCooldownTicks Возвращает количество тиков, оставшееся до следующей атаки.
 */
class Building(id: Long,
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
               val `type`: BuildingType,
               val visionRange: Double,
               val attackRange: Double,
               val damage: Int,
               val cooldownTicks: Int,
               val remainingActionCooldownTicks: Int) extends LivingUnit(id, x, y, speedX, speedY, angle, faction, radius, life, maxLife, statuses)
