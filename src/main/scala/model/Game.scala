package model

/**
 * Предоставляет доступ к различным игровым константам.
 * @param randomSeed Возвращает некоторое число, которое ваша стратегия может использовать для инициализации генератора
 *                   случайных чисел. Данное значение имеет рекомендательный характер, однако позволит более точно воспроизводить
 *                   прошедшие игры.
 * @param tickCount Возвращает базовую длительность игры в тиках. Реальная длительность может отличаться от этого значения в
 *                  меньшую сторону. Эквивалентно { @code world.tickCount}.
 * @param mapSize Возвращает размер (ширину и высоту) карты.
 * @param skillsEnabled Возвращает { @code true}, если и только если в данной игре волшебники могут повышать свой уровень
 *                      (накапливая опыт) и изучать новые умения.
 * @param rawMessagesEnabled Возвращает { @code true}, если и только если верховные волшебники в данной игре могут передавать
 *                           низкоуровневые сообщения другим волшебникам своей фракции.
 * @param friendlyFireDamageFactor Возвращает коэффициент урона, наносимого волшебниками одной фракции друг другу в результате
 *                                 дружественного огня.
 *                                 <p>
 *                                 Значение зависит от режима игры, но не может выходить за границы интервала от { @code 0.0} до { @code 1.0}.
 *                                 <p>
 *                                 Вне зависимости от режима игры, волшебники не могут наносить урон союзным миньонам и структурам.
 * @param buildingDamageScoreFactor Возвращает коэффициент опыта, получаемого волшебником при нанесении урона строениям противоположной
 *                                  фракции.
 * @param buildingEliminationScoreFactor Возвращает коэффициент опыта, получаемого волшебником за разрушение строения противоположной фракции.
 *                                       <p>
 *                                       Применяется к максимальному количеству жизненной энергии строения.
 * @param minionDamageScoreFactor Возвращает коэффициент опыта, получаемого волшебником при нанесении урона миньонам другой фракции.
 * @param minionEliminationScoreFactor Возвращает коэффициент опыта, получаемого волшебником за уничтожение миньона другой фракции.
 *                                     <p>
 *                                     Применяется к максимальному количеству жизненной энергии миньона.
 * @param wizardDamageScoreFactor Возвращает коэффициент опыта, получаемого волшебником при нанесении урона волшебникам противоположной
 *                                фракции.
 * @param wizardEliminationScoreFactor Возвращает коэффициент опыта, получаемого волшебником за разрушение телесной оболочки волшебника
 *                                     противоположной фракции.
 *                                     <p>
 *                                     Применяется к максимальному количеству жизненной энергии волшебника.
 * @param teamWorkingScoreFactor Возвращает мультипликатор опыта, применяемый в случае уничтожения юнита противника при участии двух или
 *                               более волшебников.
 *                               <p>
 *                               После применения мультипликатора количество опыта округляется вниз до ближайшего целого значения.
 * @param victoryScore Возвращает количество баллов, получаемых всеми игроками фракции в случае победы --- разрушения базы
 *                     противоположной фракции.
 * @param scoreGainRange Возвращает максимальное расстояние, на котором волшебник получает опыт при уничтожении союзником юнита
 *                       другой фракции.
 *                       <p>
 *                       При уничтожении противника опыт равномерно распределяется между всеми волшебниками, находящимися на расстоянии от
 *                       цели, на превышающем { @code scoreGainRange}, а также юнитом, нанёсшим урон, если это тоже волшебник.
 *                       <p>
 *                       При нанесении противнику урона, не приводящему к уничтожению юнита, данный параметр не применяется, а опыт
 *                       полностью достаётся атакующему волшебнику. В случае атаки миньона или строения опыт не достаётся никому.
 *                       <p>
 *                       Учитывается расстояние между центрами юнитов.
 * @param rawMessageMaxLength Возвращает максимально возможную длину низкоуровневого сообщения.
 *                            <p>
 *                            Сообщения, длина которых превышает указанное значение, будут проигнорированы.
 * @param rawMessageTransmissionSpeed Возвращает скорость отправки сообщения.
 *                                    <p>
 *                                    Если текстовая часть сообщения пуста, то адресат получит его уже в следующий игровой тик. В противном случае,
 *                                    момент получения сообщения будет отложен на { @code ceil(message.rawMessage.length / rawMessageTransmissionSpeed)}
 *                                    игровых тиков.
 * @param wizardRadius Возвращает радиус волшебника.
 * @param wizardCastRange Возвращает базовую дальность заклинаний волшебника.
 *                        <p>
 *                        Эффективная дальность ({ @code wizard.castRange}) может быть выше в результате действия некоторых аур и/или
 *                        изучения волшебником некоторых умений.
 * @param wizardVisionRange Возвращает максимальное расстояние (от центра до центра), на котором волшебник обнаруживает другие
 *                          объекты.
 * @param wizardForwardSpeed Возвращает базовое ограничение скорости волшебника при движении вперёд.
 *                           <p>
 *                           Эффективное ограничение может быть выше в результате действия некоторых аур и/или изучения волшебником некоторых
 *                           умений, а также в результате действия статуса { @code HASTENED}.
 * @param wizardBackwardSpeed Возвращает базовое ограничение скорости волшебника при движении назад.
 *                            <p>
 *                            Эффективное ограничение может быть выше в результате действия некоторых аур и/или изучения волшебником некоторых
 *                            умений, а также в результате действия статуса { @code HASTENED}.
 * @param wizardStrafeSpeed Возвращает базовое ограничение скорости волшебника при движении боком.
 *                          <p>
 *                          Эффективное ограничение может быть выше в результате действия некоторых аур и/или изучения волшебником некоторых
 *                          умений, а также в результате действия статуса { @code HASTENED}.
 * @param wizardBaseLife Возвращает максимальное значение жизненной энергии волшебника на уровне { @code 0}.
 * @param wizardLifeGrowthPerLevel Возвращает прирост жизненной энергии волшебника за уровень.
 * @param wizardBaseMana Возвращает максимальное значение магической энергии волшебника на уровне { @code 0}.
 * @param wizardManaGrowthPerLevel Возвращает прирост магической энергии волшебника за уровень.
 * @param wizardBaseLifeRegeneration Возвращает количество жизненной энергии, которое волшебник уровня { @code 0} восстанавливает за один тик.
 * @param wizardLifeRegenerationGrowthPerLevel Возвращает прирост скорости регенерации жизненной энергии волшебника за один уровень.
 * @param wizardBaseManaRegeneration Возвращает количество магической энергии, которое волшебник уровня { @code 0} восстанавливает за один тик.
 * @param wizardManaRegenerationGrowthPerLevel Возвращает прирост скорости регенерации магической энергии волшебника за один уровень.
 * @param wizardMaxTurnAngle Возвращает базовое ограничение на изменение угла поворота волшебника за один тик.
 *                           <p>
 *                           Эффективное ограничение может быть выше в { @code 1.0 + hastenedRotationBonusFactor} раз в результате действия
 *                           статуса { @code HASTENED}.
 * @param wizardMaxResurrectionDelayTicks Возвращает максимально возможную задержку возрождения волшебника после смерти его телесной оболочки.
 *                                        <p>
 *                                        Если волшебник погибает сразу после своего возрождения, то он будет автоматически воскрешён на своей начальной
 *                                        позиции (или недалеко от неё, если это невозможно) через { @code wizardMaxResurrectionDelayTicks} тиков. Каждый
 *                                        игровой тик жизни волшебника уменьшшает эту задержку на единицу. Задержка возрождения не может стать меньше, чем
 *                                        { @code wizardMinResurrectionDelayTicks}.
 * @param wizardMinResurrectionDelayTicks Возвращает минимально возможную задержку возрождения волшебника после смерти его телесной оболочки.
 *                                        <p>
 *                                        Если волшебник погибает сразу после своего возрождения, то он будет автоматически воскрешён на своей начальной
 *                                        позиции (или недалеко от неё, если это невозможно) через { @code wizardMaxResurrectionDelayTicks} тиков. Каждый
 *                                        игровой тик жизни волшебника уменьшшает эту задержку на единицу. Задержка возрождения не может стать меньше, чем
 *                                        { @code wizardMinResurrectionDelayTicks}.
 * @param wizardActionCooldownTicks Возвращает минимально возможную задержку между любыми двумя последовательными действиями волшебника.
 * @param staffCooldownTicks Возвращает минимально возможную задержку между двумя последовательными ударами посохом.
 * @param magicMissileCooldownTicks Возвращает минимально возможную задержку между двумя последовательными заклинаниями <<Магическая
 *                                  ракета>>.
 * @param frostBoltCooldownTicks Возвращает минимально возможную задержку между двумя последовательными заклинаниями <<Ледяная стрела>>.
 * @param fireballCooldownTicks Возвращает минимально возможную задержку между двумя последовательными заклинаниями <<Огненный шар>>.
 * @param hasteCooldownTicks Возвращает минимально возможную задержку между двумя последовательными заклинаниями <<Ускорение>>.
 * @param shieldCooldownTicks Возвращает минимально возможную задержку между двумя последовательными заклинаниями <<Щит>>.
 * @param magicMissileManacost Возвращает количество магической энергии, требуемой для заклинания <<Магическая ракета>>.
 * @param frostBoltManacost Возвращает количество магической энергии, требуемой для заклинания <<Ледяная стрела>>.
 * @param fireballManacost Возвращает количество магической энергии, требуемой для заклинания <<Огненный шар>>.
 * @param hasteManacost Возвращает количество магической энергии, требуемой для заклинания <<Ускорение>>.
 * @param shieldManacost Возвращает количество магической энергии, требуемой для заклинания <<Щит>>.
 * @param staffDamage Возвращает базовый урон удара посохом.
 *                    <p>
 *                    Эффективный урон может быть выше в результате действия некоторых аур и/или изучения волшебником некоторых
 *                    умений.
 * @param staffSector Возвращает сектор действия посоха волшебника.
 *                    <p>
 *                    Атака посохом поражает все живые объекты в секторе от { @code -staffSector / 2.0} до { @code staffSector / 2.0}.
 *                    Этим же интервалом ограничены относительный угол снаряда, а также зона применения магического статуса.
 * @param staffRange Возвращает дальность действия посоха волшебника.
 *                   <p>
 *                   Атака посохом поражает все живые объекты, для каждого из которых верно, что расстояние от его центра до центра
 *                   волшебника не превышает значение { @code staffRange + livingUnit.radius}.
 * @param levelUpXpValues Возвращает последовательность неотрицательных целых чисел.
 *                        <p>
 *                        Количество чисел равно количеству уровней, которые волшебник может получить в данном режиме игры. Значение с
 *                        индексом { @code N} определяет количество опыта, которое необходимо набрать волшебнику уровня { @code N} для
 *                        получения следующего уровня. Таким образом, количество опыта, необходимое волшебнику начального уровня для
 *                        получения уровня { @code N}, равно сумме первых { @code N} элементов.
 * @param minionRadius Возвращает радиус миньона.
 * @param minionVisionRange Возвращает максимальное расстояние (от центра до центра), на котором миньон обнаруживает другие
 *                          объекты.
 * @param minionSpeed Возвращает скорость миньона при движении вперёд.
 *                    <p>
 *                    Миньонам недоступно использование других видов движения, а также перемещение со скоростью, отличной от указанной.
 * @param minionMaxTurnAngle Возвращает ограничение на изменение угла поворота миньона за один тик.
 * @param minionLife Возвращает максимальное значение жизненной энергии миньона.
 * @param factionMinionAppearanceIntervalTicks Возвращает интервал, с которым появляются миньоны двух противостоящих фракций ({ @code ACADEMY} и
 *                                             { @code RENEGADES}).
 *                                             <p>
 *                                             Миньоны каждой из этих фракций появляются тремя группами (по одной на дорожку) недалеко от своей базы. Группа
 *                                             состоит и трёх орков и одного фетиша. Сразу после появления миньоны начинают продвижение по своей дорожке в
 *                                             сторону базы противоположной фракции, при этом атакуя всех противников на своём пути.
 * @param orcWoodcutterActionCooldownTicks Возвращает минимально возможную задержку между двумя последовательными атаками орка-дровосека.
 * @param orcWoodcutterDamage Возвращает урон одной атаки орка-дровосека.
 * @param orcWoodcutterAttackSector Возвращает сектор действия топора орка.
 *                                  <p>
 *                                  Атака топором поражает все живые объекты в секторе от { @code -orcWoodcutterAttackSector / 2.0} до
 *                                  { @code orcWoodcutterAttackSector / 2.0}.
 * @param orcWoodcutterAttackRange Возвращает дальность действия топора орка.
 *                                 <p>
 *                                 Атака топором поражает все живые объекты, для каждого из которых верно, что расстояние от его центра до центра
 *                                 орка-дровосека не превышает значение { @code orcWoodcutterAttackRange + livingUnit.radius}.
 * @param fetishBlowdartActionCooldownTicks Возвращает минимально возможную задержку между двумя последовательными атаками фетиша.
 * @param fetishBlowdartAttackRange Возвращает дальность полёта дротика, выпущенного фетишем.
 * @param fetishBlowdartAttackSector Возвращает сектор метания дротика фетишем.
 *                                   <p>
 *                                   Угол полёта дротика относительно направления фетиша ограничен интервалом от
 *                                   { @code -fetishBlowdartAttackSector / 2.0} до { @code fetishBlowdartAttackSector / 2.0}.
 * @param bonusRadius Возвращает радиус бонуса.
 * @param bonusAppearanceIntervalTicks Возвращает интервал появления бонусов.
 *                                     <p>
 *                                     Каждый раз по прошествии указанного интервала симулятор игры создаёт до двух бонусов в точках
 *                                     ({ @code mapSize * 0.3}, { @code mapSize * 0.3}) и ({ @code mapSize * 0.7}, { @code mapSize * 0.7}). Если любая часть
 *                                     области появления бонуса уже занята волшебником или другим бонусом, то создание бонуса будет отложено до
 *                                     окончания очередного интервала.
 * @param bonusScoreAmount Возвращает количество баллов, начисляемых игроку, волшебник которого подробрал бонус.
 *                         <p>
 *                         Сам волшебник получает такое же количество опыта.
 * @param dartRadius Возвращает радиус дротика.
 * @param dartSpeed Возвращает скорость полёта дротика.
 * @param dartDirectDamage Возвращает урон дротика.
 * @param magicMissileRadius Возвращает радиус <<Магической ракеты>>.
 * @param magicMissileSpeed Возвращает скорость полёта <<Магической ракеты>>.
 * @param magicMissileDirectDamage Возвращает урон <<Магической ракеты>>.
 * @param frostBoltRadius Возвращает радиус <<Ледяной стрелы>>.
 * @param frostBoltSpeed Возвращает скорость полёта <<Ледяной стрелы>>.
 * @param frostBoltDirectDamage Возвращает урон <<Ледяной стрелы>>.
 * @param fireballRadius Возвращает радиус <<Огненного шара>>.
 * @param fireballSpeed Возвращает скорость полёта <<Огненного шара>>.
 * @param fireballExplosionMaxDamageRange Возвращает радиус области, в которой живые юниты получают максимальный урон от взрыва <<Огненного шара>>.
 * @see #getFireballExplosionMaxDamage()
 * @param fireballExplosionMinDamageRange Возвращает радиус области, в которой живые юниты получают какой-либо урон от взрыва <<Огненного шара>>.
 * @see #getFireballExplosionMaxDamage()
 * @param fireballExplosionMaxDamage Возвращает урон <<Огненного шара>> в эпицентре взрыва.
 *                                   <p>
 *                                   Живой юнит получает { @code fireballExplosionMaxDamage} единиц урона, если расстояние от центра взрыва до
 *                                   ближайшей точки этого юнита не превышает { @code fireballExplosionMaxDamageRange}. По мере увеличения расстояния
 *                                   до { @code fireballExplosionMinDamageRange}, урон <<Огненного шара>> равномерно снижается и достигает
 *                                   { @code fireballExplosionMinDamage}. Если расстояние от центра взрыва до ближайшей точки живого юнита превышает
 *                                   { @code fireballExplosionMinDamageRange}, то урон ему не наносится.
 *                                   <p>
 *                                   Если живой юнит получил какой-либо урон от взрыва <<Огненного шара>>, то он загорается ({ @code BURNING}).
 * @param fireballExplosionMinDamage Возвращает урон <<Огненного шара>> на периферии взрыва.
 * @see #getFireballExplosionMaxDamage()
 * @param guardianTowerRadius Возвращает радиус охранной башни.
 * @param guardianTowerVisionRange Возвращает максимальное расстояние (от центра до центра), на котором охранная башня обнаруживает другие
 *                                 объекты.
 * @param guardianTowerLife Возвращает начальное значение жизненной энергии охранной башни.
 * @param guardianTowerAttackRange Возвращает максимальное расстояние (от центра до центра), на котором охранная башня может атаковать
 *                                 другие объекты.
 * @param guardianTowerDamage Возвращает урон одной атаки охранной башни.
 * @param guardianTowerCooldownTicks Возвращает минимально возможную задержку между двумя последовательными атаками охранной башни.
 * @param factionBaseRadius Возвращает радиус базы фракции.
 * @param factionBaseVisionRange Возвращает максимальное расстояние (от центра до центра), на котором база фракции обнаруживает другие
 *                               объекты.
 * @param factionBaseLife Возвращает начальное значение жизненной энергии базы фракции.
 * @param factionBaseAttackRange Возвращает максимальное расстояние (от центра до центра), на котором база фракции может атаковать
 *                               другие объекты.
 * @param factionBaseDamage Возвращает урон одной атаки базы фракции.
 * @param factionBaseCooldownTicks Возвращает минимально возможную задержку между двумя последовательными атаками базы фракции.
 * @param burningDurationTicks Возвращает длительность действия статуса { @code BURNING}.
 * @param burningSummaryDamage Возвращает суммарный урон, получаемый живым юнитом за время действия статуса { @code BURNING}.
 * @param empoweredDurationTicks Возвращает длительность действия статуса { @code EMPOWERED}.
 * @param empoweredDamageFactor Возвращает мультипликатор урона, наносимого живым юнитом под действием статуса { @code EMPOWERED}.
 *                              <p>
 *                              Мультипликатор применяется к ударам в ближнем бою, прямым попаданиям снарядов, а также взрыву <<Огненного шара>>,
 *                              но не применяется к урону, получаемому от статусов.
 * @param frozenDurationTicks Возвращает длительность действия статуса { @code FROZEN}.
 * @param hastenedDurationTicks Возвращает длительность действия статуса { @code HASTENED}.
 * @param hastenedBonusDurationFactor Возвращает мультилпикатор длительности действия статуса { @code HASTENED} в случае подбора бонуса.
 * @param hastenedMovementBonusFactor Возвращает относительное увеличение скорости перемещения в результате дествия статуса { @code HASTENED}.
 *                                    <p>
 *                                    Увеличение скорости от действия статуса { @code HASTENED} и увеличение скорости в результате изучения умений,
 *                                    являющихся пререквизитами умения { @code HASTE}, являются аддитивными. Таким образом, максимальное значение
 *                                    скорости волшебника составляет
 *                                    { @code 1.0 + 4.0 * movementBonusFactorPerSkillLevel + hastenedMovementBonusFactor} от базовой.
 * @param hastenedRotationBonusFactor Возвращает относительное увеличение скорости поворота в результате дествия статуса { @code HASTENED}.
 * @param shieldedDurationTicks Возвращает длительность действия статуса { @code SHIELDED}.
 * @param shieldedBonusDurationFactor Возвращает мультилпикатор длительности действия статуса { @code SHIELDED} в случае подбора бонуса.
 * @param shieldedDirectDamageAbsorptionFactor Возвращает часть урона, поглощаемую щитом.
 *                                             <p>
 *                                             Снижение урона применяется к ударам в ближнем бою, прямым попаданиям снарядов, а также взрыву <<Огненного шара>>,
 *                                             но не применяется к урону, получаемому от статусов.
 * @param auraSkillRange Возвращает дальность действия аур.
 * @param rangeBonusPerSkillLevel Возвращает абсолютное увеличение дальности заклинаний волшебника за каждое последовательное изучение
 *                                умения, являющегося одним из пререквизитов умения { @code ADVANCED_MAGIC_MISSILE}.
 * @param magicalDamageBonusPerSkillLevel Возвращает абсолютное увеличение урона, наносимого волшебником в результате прямых попаданий магических
 *                                        снарядов и взрыва <<Огненного шара>>, за каждое последовательное изучение умения, являющегося одним из
 *                                        пререквизитов умения { @code FROST_BOLT}.
 * @param staffDamageBonusPerSkillLevel Возвращает абсолютное увеличение урона, наносимого волшебником в ближнем бою, за каждое последовательное
 *                                      изучение умения, являющегося одним из пререквизитов умения { @code FIREBALL}.
 * @param movementBonusFactorPerSkillLevel Возвращает относительное увеличение скорости перемещения за каждое последовательное изучение умения,
 *                                         являющегося одним из пререквизитов умения { @code HASTE}.
 *                                         <p>
 *                                         Увеличение скорости от действия статуса { @code HASTENED} и увеличение скорости в результате изучения умений,
 *                                         являющихся пререквизитами умения { @code HASTE}, являются аддитивными. Таким образом, максимальное значение
 *                                         скорости волшебника составляет
 *                                         { @code 1.0 + 4.0 * movementBonusFactorPerSkillLevel + hastenedMovementBonusFactor} от базовой.
 * @param magicalDamageAbsorptionPerSkillLevel Возвращает абсолютное уменьшение урона, получаемого волшебником в результате прямых попаданий магических
 *                                             снарядов, взрыва <<Огненного шара>> и атак строений, за каждое последовательное изучение умения, являющегося
 *                                             одним из пререквизитов умения { @code SHIELD}.
 */
class Game(val randomSeed: Long,
           val tickCount: Int,
           val mapSize: Double,
           val skillsEnabled: Boolean,
           val rawMessagesEnabled: Boolean,
           val friendlyFireDamageFactor: Double,
           val buildingDamageScoreFactor: Double,
           val buildingEliminationScoreFactor: Double,
           val minionDamageScoreFactor: Double,
           val minionEliminationScoreFactor: Double,
           val wizardDamageScoreFactor: Double,
           val wizardEliminationScoreFactor: Double,
           val teamWorkingScoreFactor: Double,
           val victoryScore: Int,
           val scoreGainRange: Double,
           val rawMessageMaxLength: Int,
           val rawMessageTransmissionSpeed: Double,
           val wizardRadius: Double,
           val wizardCastRange: Double,
           val wizardVisionRange: Double,
           val wizardForwardSpeed: Double,
           val wizardBackwardSpeed: Double,
           val wizardStrafeSpeed: Double,
           val wizardBaseLife: Int,
           val wizardLifeGrowthPerLevel: Int,
           val wizardBaseMana: Int,
           val wizardManaGrowthPerLevel: Int,
           val wizardBaseLifeRegeneration: Double,
           val wizardLifeRegenerationGrowthPerLevel: Double,
           val wizardBaseManaRegeneration: Double,
           val wizardManaRegenerationGrowthPerLevel: Double,
           val wizardMaxTurnAngle: Double,
           val wizardMaxResurrectionDelayTicks: Int,
           val wizardMinResurrectionDelayTicks: Int,
           val wizardActionCooldownTicks: Int,
           val staffCooldownTicks: Int,
           val magicMissileCooldownTicks: Int,
           val frostBoltCooldownTicks: Int,
           val fireballCooldownTicks: Int,
           val hasteCooldownTicks: Int,
           val shieldCooldownTicks: Int,
           val magicMissileManacost: Int,
           val frostBoltManacost: Int,
           val fireballManacost: Int,
           val hasteManacost: Int,
           val shieldManacost: Int,
           val staffDamage: Int,
           val staffSector: Double,
           val staffRange: Double,
           _levelUpXpValues: Array[Int],
           val minionRadius: Double,
           val minionVisionRange: Double,
           val minionSpeed: Double,
           val minionMaxTurnAngle: Double,
           val minionLife: Int,
           val factionMinionAppearanceIntervalTicks: Int,
           val orcWoodcutterActionCooldownTicks: Int,
           val orcWoodcutterDamage: Int,
           val orcWoodcutterAttackSector: Double,
           val orcWoodcutterAttackRange: Double,
           val fetishBlowdartActionCooldownTicks: Int,
           val fetishBlowdartAttackRange: Double,
           val fetishBlowdartAttackSector: Double,
           val bonusRadius: Double,
           val bonusAppearanceIntervalTicks: Int,
           val bonusScoreAmount: Int,
           val dartRadius: Double,
           val dartSpeed: Double,
           val dartDirectDamage: Int,
           val magicMissileRadius: Double,
           val magicMissileSpeed: Double,
           val magicMissileDirectDamage: Int,
           val frostBoltRadius: Double,
           val frostBoltSpeed: Double,
           val frostBoltDirectDamage: Int,
           val fireballRadius: Double,
           val fireballSpeed: Double,
           val fireballExplosionMaxDamageRange: Double,
           val fireballExplosionMinDamageRange: Double,
           val fireballExplosionMaxDamage: Int,
           val fireballExplosionMinDamage: Int,
           val guardianTowerRadius: Double,
           val guardianTowerVisionRange: Double,
           val guardianTowerLife: Double,
           val guardianTowerAttackRange: Double,
           val guardianTowerDamage: Int,
           val guardianTowerCooldownTicks: Int,
           val factionBaseRadius: Double,
           val factionBaseVisionRange: Double,
           val factionBaseLife: Double,
           val factionBaseAttackRange: Double,
           val factionBaseDamage: Int,
           val factionBaseCooldownTicks: Int,
           val burningDurationTicks: Int,
           val burningSummaryDamage: Int,
           val empoweredDurationTicks: Int,
           val empoweredDamageFactor: Double,
           val frozenDurationTicks: Int,
           val hastenedDurationTicks: Int,
           val hastenedBonusDurationFactor: Double,
           val hastenedMovementBonusFactor: Double,
           val hastenedRotationBonusFactor: Double,
           val shieldedDurationTicks: Int,
           val shieldedBonusDurationFactor: Double,
           val shieldedDirectDamageAbsorptionFactor: Double,
           val auraSkillRange: Double,
           val rangeBonusPerSkillLevel: Double,
           val magicalDamageBonusPerSkillLevel: Int,
           val staffDamageBonusPerSkillLevel: Int,
           val movementBonusFactorPerSkillLevel: Double,
           val magicalDamageAbsorptionPerSkillLevel: Int) {

    lazy val levelUpXpValues = if (_levelUpXpValues == null) null else Array() ++ _levelUpXpValues
}
