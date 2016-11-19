package model

final class PlayerContext(_wizards: Array[Wizard],
                          val world: World) {

    lazy val wizards = if (_wizards == null) null else Array() ++ _wizards
}
