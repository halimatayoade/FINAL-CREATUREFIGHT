import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.JOptionPane;

/**
 * TODO (79): Copy all code below public class Golem and paste it below.
 *          You will make a few changes to the code to make it appropriate for
 *          Ivysaur. These are listed in order from top to bottom:
 *              - Change the constructor to say Ivysaur instead of Golem
 *              - Ivysaur has 720 points of health
 *              - Ivysaur's type is Grass
 *              - Show text that Ivysaur has fainted when its health bar's value is 
 *                less than or equal to 0
 *                  - When Ivysaur faints, the second thing you should be checking is if getNewOneCreature 
 *                    at 1 still has health
 *                      - You should be switching to Creature at index 1 if this is the case
 *              - Ivysaur's second attack...
 *                  - if used against an electric type...
 *                      - Should do half of 60 points of damage (DON'T DO THE MATH! Write the math expression)
 *                      - Should display that the attack is not very effective at a location of
 *                        half the width of the world and half the height of the world plus 26
 *                  - otherwise, if used against a flying type...
 *                      - Should do half of 60 points of damage (DON'T DO THE MATH!)
 *                      - Should display that the attack is not very effective at a location of
 *                        half the width of the world and half the height of the world plus 26
 *                  - otherwise, if used against a water type...
 *                      - Should do two times 60 points of damage (DON'T DO THE MATH!)
 *                      - Should display that the attack is super effective at a location of
 *                        half the width of the world and half the height of the world plus 26
 *                      - Delay the scenario by 30 cycles
 *                  - otherwise...
 *                      - Should do 60 points of damage
 *              - In switchCreature...
 *                      - In the else condition...
 *                          - Change player one to Golem
 *              
 */
public class Ivysaur extends Creature
{
   /**
     * Constructor for objects of class Charmander
     * 
     * @param w is a reference to the world that Charmander gets added to
     * @return An object of type Charmander
     */
   public Ivysaur(World w)
   {
        super(720, 1, "Grass");
        getImage().scale(150, 100);
        w.addObject( getHealthBar() , 950, w.getHeight() - 50 );
        getImage().setTransparency(0);
   }
    
   /**
     * Act - do whatever the Charmander wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
   public void act() 
   {
        CreatureWorld playerWorld = (CreatureWorld)getWorld();

        if( getHealthBar().getCurrent() <= 0 )
        {
            getWorld().showText("Ivysaur has fainted...", getWorld().getWidth()/2, getWorld().getHeight()/2 + 26);
            Greenfoot.delay(30);
            
            //TODO (68): If the current health of the health bar of the new one creature at index 1 in player world is greater than 0...
            if(playerWorld.getNewOneCreature(1).getHealthBar().getCurrent()>0)
            {
                //TODO (69): Call the switchCreature method using a value of 1 as the parameter
                switchCreature(1);
                
                //TODO (70): Set the turn number in player world to 1
                playerWorld.setTurnNumber(1);
                
                //TODO (71): Clear the text (using an empty String, "") at the location that it stated Charmander had fainted
                getWorld().showText("",getWorld().getWidth()/2, getWorld().getHeight()/2 + 26);
                
                //TODO (72): Remove this object from the world
                getWorld().removeObject(this);
            }    
            
            //TODO (73): Otherwise, if the current health of the health bar of the new one creature at index 2 in player world is greater than 0...
            else if(playerWorld.getNewOneCreature(2).getHealthBar().getCurrent() > 0)
            {
                //TODO (74): Call the switchCreature method using a value of 2 as the parameter
                switchCreature(2);
                
                //TODO (75): Set the turn number in player world to 1
                playerWorld.setTurnNumber(1);
                
                //TODO (76): Clear the text (using an empty String, "") at the location that it stated Charmander had fainted
                getWorld().showText("",getWorld().getWidth()/2, getWorld().getHeight()/2 + 26);
                
                //TODO (77): Remove this object from the world
                getWorld().removeObject(this);
            }
        }
   }

   /**
     * attack takes away health from the enemy Creature using one of
     * two predefined attacks
     * 
     * @param idx is the index of the attack option selected
     * @return Nothing is returned
     */
   public void attack(int idx)
   {
        CreatureWorld playerWorld = (CreatureWorld)getWorld();
        Creature enemy = playerWorld.getPlayerTwo();
        String enemyType = enemy.getType();
        
        //TODO (39): Make a call to the attackAnimation method
        attackAnimation();

        if( idx == 0 )
        {
            enemy.getHealthBar().add( -30 );
        }
        else
        { //Should do two times 75 points of damage (DON'T DO THE MATH! Write the math expression)
            //TODO (40): If the enemy type equals (ignoring case) Water...
            if (enemyType == "Electric")
                //TODO (41): The enemy only receives half damage of the normal attack (70 points). DON'T DO THE MATH! Just type the mathematical expression you would use
            {    
                enemy.getHealthBar().add(60*2);
                /**
                 * TODO (42): Show text that states the attack was not very effective at a x location of half the width of the world 
                 *          and a y location of half the height of the world plus 26 pixels
                 */
                getWorld().showText("the attack was not very effective", getWorld().getWidth()/2, getWorld().getHeight()/2 + 26);
                
                //TODO (43): Delay the scenario by 30 pixels
                Greenfoot.delay(30);
            }
            else if ( enemyType == "Flying" )
           {
               //Should do 0 damage
               enemy.getHealthBar().add(60*2);
               
               /**
                * Should display that the attack has no effect at a location of 
                * half the width of the world and half the height of the world plus 26
                */
               
               getWorld().showText("This attack has no effect", getWorld().getWidth()/2,getWorld().getHeight()/2+26); 
               
               //Delay the scenario by 30 pixels
                
               Greenfoot.delay(30);
           }
           else if ( enemyType == "Water" )
           {
               //Should do 0 damage
               enemy.getHealthBar().add(60*5);
               
               /**
                * Should display that the attack has no effect at a location of 
                * half the width of the world and half the height of the world plus 26
                */
               
               getWorld().showText("This attack has no effect", getWorld().getWidth()/2,getWorld().getHeight()/2+26); 
               
               //Delay the scenario by 30 pixels
               Greenfoot.delay(30);
            }   
            //TODO (44): Otherwise...
            else
            {
                //TODO (45): Take the line from below that takes away 70 points of health and place it inside this else
                enemy.getHealthBar().add( -60 );
            }    
            
        }

        playerWorld.setTurnNumber(2);
   }
    
   /**
     * TODO (33): Declare an attackAnimation method that has no
     *          parameters and no return type
     *          
     * TODO (34): Declare two local variables, originalX and originalY
     *          that are set to the current X and current Y locations
     *          
     * TODO (35): Declare a loop that will run 15 times
     * 
     *      TODO (36): Set the location to 1 more than the current X location
     *               and two less than the current y location (you shouldn't
     *               be using the variables that you created earlier)
     *               
     *      TODO (37): Delay the scenario 1 act cycle
     *      
     * TODO (38): Set the location back to the original x and y locations 
     */
   private void attackAnimation()
   {
        int originalX = getX();
        int originalY = getY();
        for(int count = 0; count < 15; count++)
        {
            setLocation(getX()+1, getY()-2);
            Greenfoot.delay(1);
            
        }
        setLocation(originalX, originalY);
   }

   /**
     * TODO (46): Declare a switchCreature method that will be accessed
     *          by other classes, has no return type, and has a parameter
     *          called idx
     *          
     * TODO (47): Declare a local CreatureWorld variable called playerWorld that stores a reference to the CreatureWorld
     * 
     * TODO (48): Declare a local Creature variable called switchCreature that is
     *          initialized to get a new player one creature using the idx parameter
     *          
     * TODO (49): If the current health of the health bar of the switchCreature is less than or equal to 0...
     * 
     *      TODO (50): Use JOptionPane to show a message dialog with null as the first parameter and a message that
     *               let's the player know that the Creature they have chosen to switch to has fainted and they must
     *               select a different option
     *               
     * TODO (51): Otherwise...
     * 
     *      TODO (52): Use a loop that will loop while the x location of this creature
     *               is greater than 0
     *               
     *          TODO (53): Inside this loop, set the location to 5 less than the current x location and the current y location
     *          
     *          TODO (54): Delay the scenario by 2 act cycles
     *          
     *      TODO (55): Set the transparency of the image of this object to 0
     *      
     *      TODO (56): Set the transparency of the image of the health bar to 0
     *      
     *      TODO (57): If idx is equal to 1...
     *      
     *          TODO (58): Change player one in playerWorld to Golem
     *          
     *      TODO (59): Otherwise...
     *      
     *          TODO (60): Change player one in playerWorld to Ivysaur
     *          
     *      TODO (61): Call the switchedIn method of switchCreature
     *      
     *      TODO (62): Set turn number in playerWorld to 2
     *          
     */
    //TODO (46): Declare a switchCreature method that will be acess by other classes, has no return type, and has a parameter called idx
   public void switchCreature(int idx)
   {
        //TODO (47): Declare a local CreatureWorld variable called playerWorld that stores a reference to the CreatureWorld
        CreatureWorld playerWorld = (CreatureWorld)getWorld();
        //TODO (48): Declare a local Creature variable called switchCreature that is initialized to get a new player one creature using the idx parameter
        Creature switchCreature = playerWorld.getNewOneCreature(idx);
        //TODO (49): If the current health of the health bar of the switchCreature is less than or equal to 0...
        if (getHealthBar().getCurrent()<= 0)
        {
            /**
             *    TODO (50): Use JOptionPane to show a message dialog with null as the first parameter and a message that
                   let's the player know that the Creature they have chosen to switch to has fainted and they must
                   select a different option
             */
            JOptionPane.showMessageDialog(null, "Your player has fainted!");
            
        }
        //Otherwise...
        else
        {
           //TODO (52): Use a loop that will loop while the x location of this creature is greater than 0 
           while(getX() > 0)
           {
               //TODO (53): Inside this loop, set the location to 5 less than the current x location and the current y location 
               setLocation(getX()-5, getY());
               // TODO (54): Delay the scenario by 2 act cycles
               Greenfoot.delay(2);
           }
           //TODO (55): Set the transparency of the image of this object to 0
           getImage().setTransparency(0);
           //TODO (56): Set the transparency of the image of the health bar to 0
           getHealthBar().getImage().setTransparency(0);
           //TODO (57): If idx is equal to 1...
           if(idx == 0)
           {
               //TODO (58): Change player one in playerWorld to Golem
               playerWorld.changePlayerOne("Charmander");
           }
           //Otherwise..
           else
           {
                //TODO (60): Change player one in playerWorld to Ivysaur
                playerWorld.changePlayerOne("Golem");
           }
           //TODO (61): Call the switchedIn method of switchCreature
           switchCreature.switchedIn();
           //TODO (62): Set turn number in playerWorld to 2
           (playerWorld).setTurnNumber(2);
        }
   }
   /**
     * TODO (63): Declare a method called switchedIn that will be accessed by
     *          other classes, has no return type, and no parameters
     *          
     * TODO (64): Set the transparency of the image of Charmander and the
     *          transparency of the image of the health bar to full
     *          
     * TODO (65): Declare a loop that will repeat while the x location of Charmander
     *          is less than half the width of the image of Charmander
     *          
     *      TODO (66): Set the location of Charmander to the current x location plus 5
     *               and the current y location
     *               
     *      TODO (67): Delay the scenario by two cycles
     */
   public void switchedIn()
   {
        getImage().setTransparency(100);
        while(getX()> getX()/2)
        {
            setLocation(getX()+5,getY());
            Greenfoot.delay(2);
        }
   }
  
}
