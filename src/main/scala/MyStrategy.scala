import model._

class MyStrategy extends Strategy {
    def move(self: Wizard, world: World, game: Game, move: Move) = {
        move.setSpeed(game.getWizardForwardSpeed)
        move.setStrafeSpeed(game.getWizardStrafeSpeed)
        move.setTurn(game.getWizardMaxTurnAngle)
        move.setAction(ActionType.MAGIC_MISSILE)
    }
}
