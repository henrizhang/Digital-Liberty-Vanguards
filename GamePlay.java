        import cs1.Keyboard;
        
        public class GamePlay { 
            private Map array; 
            private boolean gameOver; 
            private int numMoves; //number of times player has moved in the game
            private Game Gameswag;
            //game or string that represents a game
            private Player player1;
            
        public GamePlay() { 
            gameOver = false; 
            numMoves=-1;
            array=new Map();
            player1=new Player();
        }
        
        public String newGame() {
            String start = "";
            start += "Who U";
            array=new Map();
            player1=new Player();
            return start; 
        }
        //checks if the direction the player wants to go to is out of bounds or locked
        public boolean canGoHere(String direction) {
            if (direction.equals("w")) {
                if (array.getPlayerRow()==3){
                    if (((array.getPlayerColumn()==6)||(array.getPlayerColumn()==7)||(array.getPlayerColumn()==8))&&(!(player1.getHasAccess()))){
                        System.out.println("You need the Skeleton Key to access this building!");
                        return false;
                    }
                }
                    
                if ((this.array.getPlayerRow()-1)<0){
                    return false;
                }
            }
            
            if (direction.equals("s")) {
                if ((this.array.getPlayerRow()+1)>8){
                    return false;
                }
            }
            
            if (direction.equals("a")) { 
                if ((this.array.getPlayerColumn()-1)<0){
                    return false;
                }
            }
            
            if (direction.equals("d")) { 
                if (array.getPlayerColumn()==5){
                    if (((array.getPlayerRow()==0)||(array.getPlayerRow()==1)||(array.getPlayerRow()==2))&&(!(player1.getHasAccess()))){
                        System.out.println("You need the Skeleton Key to access this building!");
                        return false;
                    }
                }
                
                if ((this.array.getPlayerColumn()+1)>8){
                    return false;
                }
                
            }
            
            return true;
        }
        
        //whether or not a direction from the user points to a valid cell that the player has access to
        
            public static void main (String [] args) { 
                
                //Player player1 = new Player();
                GamePlay game = new GamePlay(); 
                while (!(game.gameOver)) {
                    //FIRST ITERATION OF THE LOOP IS BEFORE THE INITIAL MOVEMENT OF THE PLAYER
                    if (game.numMoves==-1) {
                        System.out.println("You have began a new game. (Press Space+enter to continue...)");
                        String input="sike";
                        while (!(input.equals(" "))) { 
                         //   input=Keyboard.readString();
                            if (!(input=Keyboard.readString()).equals(" ")) {
                                System.out.println("Incorrect input");
                            //need to enter space to continue
                        }
                        }
                        
                        System.out.println("You wake up in a strange shack. Your head aches. There is a smell of burning bacon somewhere. (Press Space+enter to continue...)");
                        input= "sike";//resetting input
                        
                        while (!(input.equals(" "))) {
                           // input=Keyboard.readString();
                            if (!(input=Keyboard.readString()).equals(" ")) {
                                System.out.println("Incorrect input");
                           
                            //need to enter space to continue
                        }
                        }
                        System.out.println("press w+enter to move north." + "\n" + "press a+enter to move west" + "\n" + 
                        "press s+enter to move south" + "\n" + "press d+enter to move east" + "\n" + "type inventory to open inventory. type stats to check your stats. press space+enter to return to the map. (Press Space+enter to continue)");
                        input="sike";//resetting input
                        while (!(input.equals(" "))) {
                         //   input=Keyboard.readString();
                            if (!(input=Keyboard.readString()).equals(" ")) {
                                System.out.println("Incorrect input. Press space+enter."); 
                            //need to enter space to continue
                        }
                        }
                        game.numMoves+=1;
                        continue;
                            // FIRST ITERATION ENDS HERE
                           
                        }
                  
                    //Initial message upon starting a new game
                    if (!(game.array.getStopMap() == 1)) {
                    System.out.println(game.array);
                    System.out.println("This is the map. Your location is marked by O. Where would you like to go?");
                    } 
                    String userCommand=Keyboard.readString(); 
                    
                    if (userCommand.equals("inventory")) {
                     //   player1._inventory.add("Key");
                        System.out.println(game.player1.stringifyInventory());     
                  //      game.array.stopMap = 1;  [private access] 
                        System.out.println("(Press Space+enter to continue)");
                        String input2="sike"; 
                        while(!(input2.equals(" "))){
                            input2=Keyboard.readString();    
                        }
                        input2="sike";
                    }
                    
                    if (userCommand.equals("stats")){
                        System.out.println(game.player1.printStats());
                        String input2="sike";
                        System.out.println("(Press Space+enter to continue)");
                        while(!(input2.equals(" "))){
                            input2=Keyboard.readString();
                        }
                        input2="sike";
                    }
                     
                    if (game.canGoHere(userCommand)){
                        game.array.movePlayer(userCommand); 
                        System.out.println(game.array.map[game.array.getPlayerRow()][game.array.getPlayerColumn()].getEnterText());
                       //game.array.changeStop(1);
                        /**
                         if (userCommand.equals(" ")) { 
                        game.array.changeStop(0); 
                    }**/ 
                    
                        if (game.array.map[game.array.getPlayerRow()][game.array.getPlayerColumn()].hasItem()) {
                                System.out.println("You found a " + game.array.theItem() + " ! " + game.array.theItem().getPurpose());
                            if (game.array.map[game.array.getPlayerRow()][game.array.getPlayerColumn()].hasPotion()) { 
                                game.player1.addHealth(250-game.player1.getHealth());
                                System.out.println("Your health is now " + game.player1.getHealth());
                                game.array.map[game.array.getPlayerRow()][game.array.getPlayerColumn()].removeItem(game.array.theItem());
                                System.out.println("Press space+enter to return to the map");
                            }
                            else if (game.array.map[game.array.getPlayerRow()][game.array.getPlayerColumn()].hasWeapon()) { 
                                game.player1.add(game.array.theItem()); 
                                if (game.array.map[game.array.getPlayerRow()][game.array.getPlayerColumn()].getItem().which() == true ) {
                                    game.player1.addStr((int)(Math.random()*6+2)); 
                                    game.array.map[game.array.getPlayerRow()][game.array.getPlayerColumn()].removeItem(game.array.theItem());
                                }
                                else game.player1.addDef((int)(Math.random()*6+2));
                                game.array.map[game.array.getPlayerRow()][game.array.getPlayerColumn()].removeItem(game.array.theItem());
                            }
                            else if (game.array.map[game.array.getPlayerRow()][game.array.getPlayerColumn()].hasBooster()) { 
                                game.player1.addStr(game.array.map[game.array.getPlayerRow()][game.array.getPlayerColumn()].getItem().random());
                                game.player1.addDef(game.array.map[game.array.getPlayerRow()][game.array.getPlayerColumn()].getItem().random());
                                game.array.map[game.array.getPlayerRow()][game.array.getPlayerColumn()].removeItem(game.array.theItem());
                            }
                            else if (game.array.map[game.array.getPlayerRow()][game.array.getPlayerColumn()].hasDrain()) { 
                                game.player1.decBoth(game.array.map[game.array.getPlayerRow()][game.array.getPlayerColumn()].getItem().random());
                                game.array.map[game.array.getPlayerRow()][game.array.getPlayerColumn()].removeItem(game.array.theItem());
                            }
                                
                            else { 
                                game.player1.add(game.array.theItem());
                                game.player1.setHasAccess(true);
                                game.array.map[game.array.getPlayerRow()][game.array.getPlayerColumn()].removeItem(game.array.theItem());
                                System.out.println("Press space+enter to return to the map"); 
                            }
                        }
                      else if (game.array.map[game.array.getPlayerRow()][game.array.getPlayerColumn()].hasMonster()) {
                     //       System.out.println("Open inventory to see what you can use to fight");  //inventory doesn't open up -- what if we don't use weapons? 
                            System.out.println("A " + game.array.theMonster() + " has appeared.");
                            System.out.println("Press b+enter to fight. Type run+enter to escape and return to the map. Defeating a monster helps you gain strength."); 
                            while (game.player1.isAlive() && game.array.map[game.array.getPlayerRow()][game.array.getPlayerColumn()].getMonster().isAlive()) {   
                            String command = Keyboard.readString(); 
                                if (command.equals("b")) { 
                                    int a1 = game.player1.attack(game.array.theMonster()); 
                                    int a2 = game.array.theMonster().attack(game.player1); 
                                    System.out.println("You attacked " + game.array.theMonster() + " and dealt " + a1 + " damage."); 
                                    System.out.println("You were attacked and lost " + a2 + " HP ");   
                                    System.out.println("Attack again"); 
                                }
                               else if (command.equals("run")) { 
                                   game.array.changeStop(0); 
                                   break; 
                                   
                            }
                            
                            else { System.out.println("Incorrect input. Try again"); } 
                            }
                            
                            if (!game.player1.isAlive() && (!game.array.map[game.array.getPlayerRow()][game.array.getPlayerColumn()].getMonster().isAlive())) { 
                                System.out.println("You have both been killed"); 
                                game.gameOver = true; 
                            }
                             
                             else if ((!game.array.map[game.array.getPlayerRow()][game.array.getPlayerColumn()].getMonster().isAlive()) && ((game.array.map[game.array.getPlayerRow()][game.array.getPlayerColumn()].isBoss()))) {
                                    System.out.println("Having defeated the greatest resister of your brutal scourge, you are now an unstoppable monster. The monsters' remnants start to dissolve and twirl around you. The dust starts to seem familiar.. This was your creation...All the monsters were created by you....I am The Mastermind.");
                                break;
                            }
                            else if (!game.array.map[game.array.getPlayerRow()][game.array.getPlayerColumn()].getMonster().isAlive()) { 
                                System.out.println("Somehow even with your limited memory, you slained the " + game.array.theMonster());
                                game.player1.addStr((int)(Math.random() * 5 + 1));
                                game.array.map[game.array.getPlayerRow()][game.array.getPlayerColumn()].removeMonster(game.array.theMonster());
                                System.out.println("Press space+enter to return to the map"); 
                            }
                             
                        else if (!game.player1.isAlive()) { 
                            System.out.println("You failed. " + game.array.theMonster() + " has killed you."); 
                            game.gameOver = true; 
                            }
                    }
                    else if (game.array.map[game.array.getPlayerRow()][game.array.getPlayerColumn()].hasGame()) {
                        Slots play = new Slots(); 
                        play.spinOnce(); 
                        System.out.println("Woah, a weird looking slot machine stands on the side. Tiny words flash on the screen: ");
                        System.out.println( "play state:\t" + play );
                        System.out.println("Type spin to keep spinning for a winning. It costs your strength+defense to spin." + "\n" + "Press w+enter to move north." + "\n" + "press a+enter to move west" + "\n" + 
                        "press s+enter to move south" + "\n" + "press d+enter to move east"); 
                        if (userCommand.equals("spin")) { 
                        	while( play.jackpot() == false ) {
            	    System.out.println( "Your spin..." + "\t" + play);
            	    System.out.println( "LOSE\n" );
            	    play.spinOnce();
            	   
            	//    game.array.map[game.array.getPlayerRow()][game.array.getPlayerColumn()].removeItem(game.array.theItem());
            	    
            	}
            	 game.player1.decBoth((int)(Math.random() * 5 + 1));
                        }
                    
                        
                        if (play.jackpot() == true) { 
            
            	System.out.println( "====================================" );
            	System.out.println( "Your spin..." + "\t" + play );
            	System.out.println( "JACKPOT!\n" );
            	
                //         game.array.map[game.array.getPlayerRow()][game.array.getPlayerColumn()].removeGame(game.array.theGame());
                         System.out.println("You won a " + play.theWin() + "!");
                         
                         if (play.theWin() instanceof Potion) {
                             game.player1.addHealth((int)(250-game.player1.getHealth()));
                             System.out.println("Your health is now " + game.player1.getHealth());
                         }
                         else if (play.theWin() instanceof Clue) { 
                             System.out.println("Your name starts......"); 
                         }
                         else if (play.theWin() instanceof Key) {
                             System.out.println("This key is useless");
                         }   
                         else if (play.theWin() instanceof Booster) { 
                              game.player1.addStr((int)(Math.random() * 6 + 1));
                              game.player1.addDef((int)(Math.random() * 6 + 1));
                              System.out.println("Your strength and defense have been increased");
                           
                         }
                         else if (play.theWin() instanceof Drain) { 
                             game.player1.decBoth((int)(Math.random() * 6 + 1));
                             System.out.println("Your strength and defense have been lowered"); 
                             
                         }
                                
                        System.out.println("Press space+enter to return to the map"); 
                    }
                    }
                    }
                    else {
                        System.out.println("You cannot go here. Try again.");
                       String input3="sike"; 
                        while(!(input3.equals(" "))) {
                            System.out.println("(Press space+enter to return to the map)");
                            input3=Keyboard.readString();    
                            
                        }
                    }
                
                if (game.gameOver == true) {
                    System.out.println("Game ends. Who are you .. guess you won't know."); 
                    break;
                }
                }
                    
            }
                
            }
            
            
            
                
                    
                
                
