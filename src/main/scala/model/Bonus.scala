package model

/**
 * Класс, определяющий бонус --- неподвижный полезный объект. Содержит также все свойства круглого юнита.
 * @param type Возвращает тип бонуса.
 */
class Bonus(id: Long,
            x: Double,
            y: Double,
            speedX: Double,
            speedY: Double,
            angle: Double,
            faction: Faction,
            radius: Double,
            val `type`: BonusType) extends CircularUnit(id, x, y, speedX, speedY, angle, faction, radius)
