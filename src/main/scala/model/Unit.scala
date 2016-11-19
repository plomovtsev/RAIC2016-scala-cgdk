package model

import java.lang.StrictMath._

/**
 * Базовый класс для определения объектов (<<юнитов>>) на игровом поле.
 * @param id Возвращает уникальный идентификатор объекта.
 * @param x  Возвращает X-координату центра объекта. Ось абсцисс направлена слева направо.
 * @param y  Возвращает Y-координату центра объекта. Ось ординат направлена сверху вниз.
 * @param speedX Возвращает X-составляющую скорости объекта. Ось абсцисс направлена слева направо.
 *               Для юнитов, способных мгновенно менять свою скорость, возвращается значение перемещения за последний тик.
 * @param speedY Возвращает Y-составляющую скорости объекта. Ось ординат направлена сверху вниз.
 *               Для юнитов, способных мгновенно менять свою скорость, возвращается значение перемещения за последний тик.
 * @param angle Возвращает угол поворота объекта в радианах. Нулевой угол соответствует направлению оси абсцисс.
 *              Положительные значения соответствуют повороту по часовой стрелке.
 * @param faction Возвращает фракцию, к которой принадлежит данный юнит.
 */
abstract class Unit(val id: Long,
                    val x: Double,
                    val y: Double,
                    val speedX: Double,
                    val speedY: Double,
                    val angle: Double,
                    val faction: Faction) {
    
    /**
     * @param x X-координата точки.
     * @param y Y-координата точки.
     * @return Возвращает ориентированный угол `[-PI, PI]` между направлением
     * данного объекта и вектором из центра данного объекта к указанной точке.
     */
    def angleTo(x: Double, y: Double): Double = {
        val absoluteAngleTo = atan2(y - this.y, x - this.x)
        var relativeAngleTo = absoluteAngleTo - angle

        while (relativeAngleTo > PI) {
            relativeAngleTo -= 2.0D * PI
        }

        while (relativeAngleTo < -PI) {
            relativeAngleTo += 2.0D * PI
        }

        relativeAngleTo
    }

    /**
     * @param unit Объект, к центру которого необходимо определить угол.
     * @return Возвращает ориентированный угол `[-PI, PI]` между направлением
     * данного объекта и вектором из центра данного объекта к центру указанного объекта.
     */
    def angleTo(unit: Unit): Double = {
        angleTo(unit.x, unit.y)
    }

    /**
     * @param x X-координата точки.
     * @param y Y-координата точки.
     * @return Возвращает расстояние до точки от центра данного объекта.
     */
    def distanceTo(x: Double, y: Double): Double = {
        hypot(x - this.x, y - this.y)
    }

    /**
     * @param unit Объект, до центра которого необходимо определить расстояние.
     * @return Возвращает расстояние от центра данного объекта до центра указанного объекта.
     */
    def distanceTo(unit: Unit): Double = {
        distanceTo(unit.x, unit.y)
    }
}
