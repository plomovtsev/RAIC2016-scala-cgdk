package model

/**
 * Класс, определяющий волшебника. Содержит также все свойства живого юнита.
 * @param ownerPlayerId Возвращает идентификатор игрока, которому принадлежит волшебник.
 * @param isMe Возвращает { @code true} в том и только том случае, если этот волшебник ваш.
 * @param mana Возвращает текущее количество магической энергии волшебника.
 * @param maxMana Возвращает максимальное количество магической энергии волшебника.
 * @param visionRange Возвращает максимальное расстояние (от центра до центра),
 *                    на котором данный волшебник обнаруживает другие объекты.
 * @param castRange Возвращает максимальное расстояние (от центра волшебника),
 *                  которое может преодолеть выпущенный им магический снаряд.
 *                  <p>
 *                  Также является максимально возможной дальностью применения заклинаний, накладывающих на цель магический статус
 *                  ({ @code HASTE} и { @code SHIELD}).
 * @param xp Возвращает количество очков опыта, полученное волшебником в процессе игры.
 * @param level Возвращает текущий уровень волшебника.
 *              <p>
 *              Начальный уровень каждого волшебника равен { @code 0}, а максимальный --- { @code game.levelUpXpValues.length}.
 *              <p>
 *              В некоторых режимах игры рост уровня волшебника может быть заблокирован.
 * @param skills Возвращает умения, изученные волшебником.
 * @param remainingActionCooldownTicks Возвращает количество тиков, оставшееся до любого следующего действия.
 *                                     <p>
 *                                     Для совершения произвольного действия { @code actionType} необходимо, чтобы оба значения
 *                                     { @code remainingActionCooldownTicks} и { @code remainingCooldownTicksByAction[actionType.ordinal()]} были равны
 *                                     нулю.
 * @param remainingCooldownTicksByAction Возвращает массив целых неотрицательных чисел. Каждая ячейка массива содержит значение количества тиков,
 *                                       оставшегося до совершения следующего действия с соответствующим индексом.
 *                                       <p>
 *                                       Например, { @code remainingCooldownTicksByAction[0]} соответствует действию { @code NONE} и всегда равно нулю.
 *                                       { @code remainingCooldownTicksByAction[1]} соответствует действию { @code STAFF} и равно количеству тиков,
 *                                       оставшемуся до совершения данного действия. { @code remainingCooldownTicksByAction[2]} соответствует действию
 *                                       { @code MAGIC_MISSILE} и так далее.
 *                                       <p>
 *                                       Для совершения произвольного действия { @code actionType} необходимо, чтобы оба значения
 *                                       { @code remainingActionCooldownTicks} и { @code remainingCooldownTicksByAction[actionType.ordinal()]} были равны
 *                                       нулю.
 * @param isMaster Возвращает { @code true} в том и только том случае, если этот волшебник является верховным.
 *                 <p>
 *                 Количество верховных волшебников в каждой фракции строго равно одному.
 * @param  messages Возвращает сообщения, предназначенные данному волшебнику, если есть право на их просмотр.
 *                  <p>
 *                  Стратегия может просматривать только сообщения, адресатом которых является управляемый ею волшебник.
 */
class Wizard(id: Long,
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
             val ownerPlayerId: Long,
             val isMe: Boolean,
             val mana: Int,
             val maxMana: Int,
             val visionRange: Double,
             val castRange: Double,
             val xp: Int,
             val level: Int,
             _skills: Array[SkillType],
             val remainingActionCooldownTicks: Int,
             _remainingCooldownTicksByAction: Array[Int],
             val isMaster: Boolean,
             _messages: Array[Message]) extends LivingUnit(id, x, y, speedX, speedY, angle, faction, radius, life, maxLife, statuses) {

    lazy val skills = if (_skills == null) null else Array() ++ _skills
    lazy val remainingCooldownTicksByAction = if (_remainingCooldownTicksByAction == null) null else Array() ++ _remainingCooldownTicksByAction
    lazy val messages = if (_messages == null) null else Array() ++ _messages
}
