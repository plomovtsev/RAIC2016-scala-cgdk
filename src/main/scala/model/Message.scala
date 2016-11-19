package model

/**
 * Класс определяет сообщение, которое верховный волшебник ({@code wizard.master}) может отправлять другим членам
 * фракции, используя телепатическую связь.
 * <p>
 * Сообщение отправляется персонально каждому волшебнику. Другие волшебники не могут его перехватить.
 * <p>
 * Адресат получает сообщение в следующий игровой тик или позднее, в зависимости от размера сообщения.
 * <p>
 * Волшебник волен проигнорировать как любую отдельную часть сообщения, так и всё сообщение целиком, однако это может
 * привести к поражению дружественной фракции.
 * @param lane Возвращает указание контролировать определённую дорожку.
 * @param skillToLearn Возвращает указание изучить какое-либо умение.
 *                     <p>
 *                     Умение может требовать предварительного изучения других умений или быть недоступно для изучения в данный момент в
 *                     связи с низким уровнем волшебника. Волшебнику рекомендуется запомнить указание и двигаться в направлении его
 *                     реализации. При этом, более позднее указание должно считаться более приоритетным.
 *                     <p>
 *                     Значение поля может быть доступно не во всех режимах игры.
 * @param rawMessage Возвращает текстовое сообщение на забытом древнем языке.
 *                   <p>
 *                   Максимальная длина сообщения составляет { @code game.rawMessageMaxLength}. При этом, скорость отправки сообщения
 *                   зависит от его длины. Если текстовая часть сообщения пуста, то адресат получит его уже в следующий игровой тик.
 *                   В противном случае, момент получения сообщения будет отложен на
 *                   { @code ceil(rawMessage.length / game.rawMessageTransmissionSpeed)} игровых тиков.
 *                   <p>
 *                   Значение поля может быть доступно не во всех режимах игры.
 */
class Message(val lane: LaneType,
              val skillToLearn: SkillType,
              _rawMessage: Array[Byte]) {

    lazy val rawMessage = if (_rawMessage == null) null else Array() ++ _rawMessage
}
