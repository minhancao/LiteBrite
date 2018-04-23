010600707 (Cao, Minh An)

the game.css file is in resources folder because LiteBrite looks for it in the resources folder

on line 122 in LiteBrite.java: scene.getStylesheets().add(LiteBrite.class.getResource("resources/game.css").toExternalForm());  