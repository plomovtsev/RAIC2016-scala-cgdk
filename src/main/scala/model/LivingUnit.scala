package model

/**
 * Класс, определяющий живого юнита круглой формы.
 * @param life Возвращает текущее количество жизненной энергии.
 * @param maxLife Возвращает максимальное количество жизненной энергии.
 */
abstract class LivingUnit(id: Long,
                          x: Double,
                          y: Double,
                          speedX: Double,
                          speedY: Double,
                          angle: Double,
                          faction: Faction,
                          radius: Double,
                          val life: Int,
                          val maxLife: Int,
                          _statuses: Array[Status]) extends CircularUnit(id, x, y, speedX, speedY, angle, faction, radius) {

    /**
     * @return Возвращает магические статусы, влияющие на живого юнита.
     */
    lazy val statuses = if (_statuses == null) null else Array() ++ _statuses
}