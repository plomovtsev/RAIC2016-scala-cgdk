package model

/**
 * Базовый класс для определения круглых объектов. Содержит также все свойства юнита.
 * @param radius Возвращает радиус объекта.
 */
abstract class CircularUnit(id: Long,
                            x: Double,
                            y: Double,
                            speedX: Double,
                            speedY: Double,
                            angle: Double,
                            faction: Faction,
                            val radius: Double) extends Unit(id, x, y, speedX, speedY, angle, faction)