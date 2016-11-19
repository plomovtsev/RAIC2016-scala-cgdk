package model

/**
 * Класс, определяющий снаряд. Содержит также все свойства круглого юнита.
 * @param type Возвращает тип снаряда.
 * @param ownerUnitId Возвращает идентификатор юнита, создавшего данный снаряд.
 * @param ownerPlayerId Возвращает идентификатор игрока, юнит которого создал данный снаряд или {@code -1}.
 */
class Projectile(id: Long,
                 x: Double,
                 y: Double,
                 speedX: Double,
                 speedY: Double,
                 angle: Double,
                 faction: Faction,
                 radius: Double,
                 val `type`: ProjectileType,
                 val ownerUnitId: Long,
                 val ownerPlayerId: Long) extends CircularUnit(id, x, y, speedX, speedY, angle, faction, radius)
