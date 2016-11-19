package model

/**
 * Класс, определяющий дерево. Содержит также все свойства живого юнита.
 */
class Tree(id: Long,
           x: Double,
           y: Double,
           speedX: Double,
           speedY: Double,
           angle: Double,
           faction: Faction,
           radius: Double,
           life: Int,
           maxLife: Int,
           statuses: Array[Status]) extends LivingUnit(id, x, y, speedX, speedY, angle, faction, radius, life, maxLife, statuses)
