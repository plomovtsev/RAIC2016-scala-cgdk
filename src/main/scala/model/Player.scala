package model

/**
 * Содержит данные о текущем состоянии игрока.
 * @param id Возвращает уникальный идентификатор игрока.
 * @param isMe Возвращает {@code true} в том и только в том случае, если этот игрок ваш.
 * @param name Возвращает имя игрока.
 * @param isStrategyCrashed Возвращает специальный флаг --- показатель того, что стратегия игрока <<упала>>.
 * Более подробную информацию можно найти в документации к игре.
 * @param score Возвращает количество баллов, набранное игроком.
 * @param faction Возвращает фракцию, к которой принадлежит данный игрок.
 */
class Player(val id: Long,
             val isMe: Boolean,
             val name: String,
             val isStrategyCrashed: Boolean,
             val score: Int,
             val faction: Faction)
