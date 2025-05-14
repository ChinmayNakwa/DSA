import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Random;
import javax.swing.*;
import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class PacMan extends JPanel implements ActionListener, KeyListener {
    
    class Block {
        int x; // X-coordinate of the block
        int y; // Y-coordinate of the block
        int width; // Width of the block
        int height; // Height of the block
        Image image; // Image representing the block
        
        int startX; // Initial X-coordinate (used for resetting position)
        int startY; // Initial Y-coordinate (used for resetting position)
        char direction = 'U'; // Current direction of movement (U, D, L, R)
        int velocityX = 0; // Horizontal velocity
        int velocityY = 0; // Vertical velocity
        
        /**
        * Create a new Block with the specified properties.
        * image The image to display for this block
        * x The initial X-coordinate
        * y The initial Y-coordinate
        * width The width of the block
        * height The height of the block
        */
        Block(Image image, int x, int y, int width, int height) {
            this.image = image;
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
            this.startX = x;
            this.startY = y;
        }
        
        // Update the direction of movement and check for wall collisions.
        void updateDirection(char direction) {
            char prevDirection = this.direction; // Store the previous direction
            this.direction = direction; // Update the direction
            updateVelocity(); // Update velocity based on the new direction
            
            // Move the block and check for collisions
            this.x += this.velocityX;
            this.y += this.velocityY;
            
            // Revert movement if it causes a collision with a wall
            for (Block wall : walls) {
                if (collision(this, wall)) {
                    this.x -= this.velocityX;
                    this.y -= this.velocityY;
                    this.direction = prevDirection; // Revert to the previous direction
                    updateVelocity(); // Update velocity again
                    break; // No need to check further walls
                }
            }
        }
        
        /**
        * Update velocity based on the current direction.
        * The speed depends on whether the block is a ghost or Pac-Man.
        */
        void updateVelocity() { 
            int speed = (this instanceof Ghost) ? ((Ghost)this).speed : tileSize/4; // Ghosts move faster
            
            if (this.direction == 'U') {
                this.velocityX = 0;
                this.velocityY = -speed; // Move up
            } else if (this.direction == 'D') {
                this.velocityX = 0;
                this.velocityY = speed; // Move down
            } else if (this.direction == 'L') {
                this.velocityX = -speed; // Move left
                this.velocityY = 0;
            } else if (this.direction == 'R') {
                this.velocityX = speed; // Move right
                this.velocityY = 0;
            }
        }
        
        // Reset the block's position to its starting coordinates.
        void reset() {
            this.x = this.startX;
            this.y = this.startY;
        }
    }
    
    /**
    * Ghost class that extends Block with additional properties
    * for ghost behavior (normal/frightened states).
    */
    class Ghost extends Block {
        Image normalImage; // Image for the ghost in normal state
        Image frightenedImage; // Image for the ghost in frightened state
        int speed; // Movement speed of the ghost
        boolean isFrightened = false; // Whether the ghost is in frightened state
        
        /**
        * Create a new Ghost with the specified properties.
        * image -> The initial image for the ghost
        * x -> The initial X-coordinate
        * y -> The initial Y-coordinate
        * width -> The width of the ghost
        * height -> The height of the ghost
        * speed -> The movement speed of the ghost
        */
        Ghost(Image image, int x, int y, int width, int height, int speed) {
            super(image, x, y, width, height);
            this.normalImage = image;
            this.speed = speed;
        }
        
        /**
        * Set the ghost to frightened or normal state.
        * frightened Whether the ghost should be frightened
        */
        void setFrightened(boolean frightened) {
            this.isFrightened = frightened;
            if (frightened) {
                this.image = frightenedImage; // Use frightened image
                this.speed = tileSize/8; // Slow down when frightened
            } else {
                this.image = normalImage; // Use normal image
                this.speed = baseGhostSpeed; // Restore normal speed
                updateVelocity(); // Update velocity based on the new speed
            }
        }
    }
    
    // Game constants
    private int rowCount = 21; // Number of rows in the game grid
    private int columnCount = 19; // Number of columns in the game grid
    private int tileSize = 32; // Size of each tile in pixels
    private int boardWidth = columnCount * tileSize; // Total width of the game board
    private int boardHeight = rowCount * tileSize; // Total height of the game board
    
    // Game state
    private enum GameState {
        STARTING, // Game is starting (countdown)
        PLAYING, // Game is in progress
        PAUSED, // Game is paused
        GAME_OVER, // Game is over
        LEVEL_COMPLETE // Level is complete
    }
    private GameState currentState = GameState.STARTING; // Current state of the game
    
    // Images
    private Image wallImage; // Image for walls
    private Image blueGhostImage; // Image for the blue ghost
    private Image orangeGhostImage; // Image for the orange ghost
    private Image pinkGhostImage; // Image for the pink ghost
    private Image redGhostImage; // Image for the red ghost
    private Image frightenedGhostImage; // Image for frightened ghosts
    
    private Image pacmanUpImage; // Image for Pac-Man facing up
    private Image pacmanDownImage; // Image for Pac-Man facing down
    private Image pacmanLeftImage; // Image for Pac-Man facing left
    private Image pacmanRightImage; // Image for Pac-Man facing right
    private Image pacmanClosedImage; // Image for Pac-Man with mouth closed
    
    // Sound
    private Clip gameSound; // Audio clip for the game sound
    
    // Game objects
    private HashSet<Block> walls; // Set of wall blocks
    private HashSet<Block> foods; // Set of food dots
    private HashSet<Ghost> ghosts; // Set of ghosts
    private HashSet<Block> powerPellets; // Set of power pellets
    private Block pacman; // Pac-Man object
    
    // Game variables
    private Timer gameLoop; // Timer for the game loop
    private final char[] directions = {'U', 'D', 'L', 'R'}; // Possible directions
    private Random random = new Random(); // Random number generator
    private int score = 0; // Current score
    private int highScore = 0; // Highest score achieved
    private int lives = 3; // Number of lives remaining
    private int level = 1; // Current level
    private int baseGhostSpeed = tileSize/4; // Base speed of ghosts
    private boolean isPowered = false; // Whether Pac-Man is in powered mode
    private int poweredTimer = 0; // Timer for powered mode
    private int startCountdown = 3; // Countdown before the game starts
    private Timer countdownTimer; // Timer for the start countdown
    
    // Animation
    
    private int animationCounter = 0; // Counter for animation frames
    
    // Map layout
    // X = wall, O = skip, P = pac man, ' ' = food, * = power pellet
    // Ghosts: b = blue, o = orange, p = pink, r = red
    private final String[] tileMap = {
        "XXXXXXXXXXXXXXXXXXX",
        "X*       X       *X",
        "X XX XXX X XXX XX X",
        "X                 X",
        "X XX X XXXXX X XX X",
        "X    X       X    X",
        "XXXX XXXX XXXX XXXX",
        "OOOX X       X XOOO",
        "XXXX X XXrXX X XXXX",
        "O       bpo       O",
        "XXXX X XXXXX X XXXX",
        "OOOX X       X XOOO",
        "XXXX X XXXXX X XXXX",
        "X        X        X",
        "X XX XXX X XXX XX X",
        "X* X     P     X *X",
        "XX X X XXXXX X X XX",
        "X    X   X   X    X",
        "X XXXXXX X XXXXXX X",
        "X                 X",
        "XXXXXXXXXXXXXXXXXXX" 
    };
    
    // Initialize the PacMan game.
    public PacMan() {
        setPreferredSize(new Dimension(boardWidth, boardHeight)); // Set the size of the game panel
        setBackground(Color.BLACK); // Set the background color
        addKeyListener(this); // Add key listener for player input
        setFocusable(true); // Allow the panel to receive key events
        
        // Load images and sound
        loadImages();
        loadSound();
        
        // Initialize game objects and state
        initializeGame();
        
        // Start the countdown before the game begins
        startCountdown();
    }
    
    // Load game images from resources.
    private void loadImages() {
        try {
            wallImage = new ImageIcon(getClass().getResource("/wall.png")).getImage();
            blueGhostImage = new ImageIcon(getClass().getResource("/blueGhost.png")).getImage();
            orangeGhostImage = new ImageIcon(getClass().getResource("/orangeGhost.png")).getImage();
            pinkGhostImage = new ImageIcon(getClass().getResource("/pinkGhost.png")).getImage();
            redGhostImage = new ImageIcon(getClass().getResource("/redGhost.png")).getImage();
            frightenedGhostImage = new ImageIcon(getClass().getResource("/frightenedGhost.png")).getImage();
            
            pacmanUpImage = new ImageIcon(getClass().getResource("/pacmanUp.png")).getImage();
            pacmanDownImage = new ImageIcon(getClass().getResource("/pacmanDown.png")).getImage();
            pacmanLeftImage = new ImageIcon(getClass().getResource("/pacmanLeft.png")).getImage();
            pacmanRightImage = new ImageIcon(getClass().getResource("/pacmanRight.png")).getImage();
            pacmanClosedImage = new ImageIcon(getClass().getResource("/closedPacman.png")).getImage();
        } catch (Exception e) {
            System.err.println("Error loading images: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    // Load game sound from resources.
    private void loadSound() {
        try {
            URL gameSoundURL = getClass().getResource("/playing-pac-man-6783.wav");
            
            if (gameSoundURL == null) {
                System.err.println("Warning: Could not find audio file. Sound will be disabled.");
                return;
            }
            
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(gameSoundURL);
            gameSound = AudioSystem.getClip();
            gameSound.open(audioInput);
        } catch (UnsupportedAudioFileException e) {
            System.err.println("Error: Audio format not supported. Please convert your audio to WAV format: " + e.getMessage());
        } catch (IOException | LineUnavailableException e) {
            System.err.println("Error loading sound: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    // Play the game sound in a loop.
    private void playGameSound() {
        if (gameSound != null) {
            if (gameSound.isRunning()) {
                gameSound.stop();
            }
            gameSound.setFramePosition(0);
            gameSound.loop(Clip.LOOP_CONTINUOUSLY);
        }
    }
    
    // Stop the game sound.
    private void stopGameSound() {
        if (gameSound != null && gameSound.isRunning()) {
            gameSound.stop();
        }
    }
    
    // Initialize the game by loading the map and setting up ghost behaviors.
    private void initializeGame() {
        loadMap(); // Load the game map
        assignGhostBehaviors(); // Assign initial behaviors to ghosts
        
        // Initialize game loop timer with 50ms interval (20 FPS)
        gameLoop = new Timer(50, this);
    }
    
    // Start the countdown before the game begins.
    private void startCountdown() {
        currentState = GameState.STARTING; // Set the game state to STARTING
        startCountdown = 3; // Reset the countdown
        
        // Start a timer to count down from 3
        countdownTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startCountdown--; // Decrement the countdown
                if (startCountdown <= 0) {
                    ((Timer)e.getSource()).stop(); // Stop the countdown timer
                    startGame(); // Start the game
                }
                repaint(); // Redraw the game panel
            }
        });
        countdownTimer.start(); // Start the countdown timer
    }
    
    // Start the game after the countdown.
    private void startGame() {
        currentState = GameState.PLAYING; // Set the game state to PLAYING
        gameLoop.start(); // Start the game loop
        playGameSound(); // Play the game sound
    }
    
    // Load the game map from the tileMap array.
    public void loadMap() {
        walls = new HashSet<>(); // Initialize the set of walls
        foods = new HashSet<>(); // Initialize the set of food dots
        ghosts = new HashSet<>(); // Initialize the set of ghosts
        powerPellets = new HashSet<>(); // Initialize the set of power pellets
        
        // Loop through each row and column of the tileMap
        for (int r = 0; r < rowCount; r++) {
            for (int c = 0; c < columnCount; c++) {
                String row = tileMap[r]; // Get the current row
                char tileMapChar = row.charAt(c); // Get the character at the current position
                
                int x = c * tileSize; // Calculate the X-coordinate
                int y = r * tileSize; // Calculate the Y-coordinate
                
                // Create the appropriate game object based on the character
                switch (tileMapChar) {
                    case 'X':  // Wall
                    Block wall = new Block(wallImage, x, y, tileSize, tileSize);
                    walls.add(wall);
                    break;
                    case 'b':  // Blue ghost
                    Ghost ghost = new Ghost(blueGhostImage, x, y, tileSize, tileSize, baseGhostSpeed);
                    ghost.frightenedImage = frightenedGhostImage;
                    ghosts.add(ghost);
                    break;
                    case 'o':  // Orange ghost
                    Ghost orangeGhost = new Ghost(orangeGhostImage, x, y, tileSize, tileSize, baseGhostSpeed);
                    orangeGhost.frightenedImage = frightenedGhostImage;
                    ghosts.add(orangeGhost);
                    break;
                    case 'p':  // Pink ghost
                    Ghost pinkGhost = new Ghost(pinkGhostImage, x, y, tileSize, tileSize, baseGhostSpeed);
                    pinkGhost.frightenedImage = frightenedGhostImage;
                    ghosts.add(pinkGhost);
                    break;
                    case 'r':  // Red ghost
                    Ghost redGhost = new Ghost(redGhostImage, x, y, tileSize, tileSize, baseGhostSpeed);
                    redGhost.frightenedImage = frightenedGhostImage;
                    ghosts.add(redGhost);
                    break;
                    case 'P':  // Pac-Man
                    pacman = new Block(pacmanRightImage, x, y, tileSize, tileSize);
                    break;
                    case ' ':  // Food dot
                    Block food = new Block(null, x + 14, y + 14, 4, 4);
                    foods.add(food);
                    break;
                    case '*':  // Power pellet
                    Block powerPellet = new Block(null, x + 10, y + 10, 12, 12);
                    powerPellets.add(powerPellet);
                    break;
                    // 'O' (skip) cases are implicitly handled by doing nothing
                }
            }
        }
    }
    
    // Assign initial behaviors to ghosts.
    private void assignGhostBehaviors() {
        for (Ghost ghost : ghosts) {
            char newDirection = directions[random.nextInt(4)]; // Choose a random direction
            ghost.updateDirection(newDirection); // Update the ghost's direction
        }
    }
    
    // Paint the game components.
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // Call the parent class's paintComponent method
        draw(g); // Draw the game elements
    }
    
    // Draw all game elements.
    public void draw(Graphics g) {
        // Draw game elements
        if (currentState != GameState.STARTING) {
            // Draw walls
            for (Block wall : walls) {
                g.drawImage(wall.image, wall.x, wall.y, wall.width, wall.height, null);
            }
            
            // Draw food
            g.setColor(Color.WHITE);
            for (Block food : foods) {
                g.fillRect(food.x, food.y, food.width, food.height);
            }
            
            // Draw power pellets
            g.setColor(Color.WHITE);
            for (Block pellet : powerPellets) {
                // Animate power pellets by changing visibility
                if (animationCounter % 20 < 10) {
                    g.fillOval(pellet.x, pellet.y, pellet.width, pellet.height);
                }
            }
            
            // Draw ghosts
            for (Ghost ghost : ghosts) {
                g.drawImage(ghost.image, ghost.x, ghost.y, ghost.width, ghost.height, null);
            }
            
            // Draw Pac-Man with animation
            if (currentState != GameState.GAME_OVER) {
                Image pacmanImage = pacman.image;
                // Pac-Man mouth open/closed animation
                if (animationCounter % 20 < 10) {
                    if (pacman.direction == 'U') {
                        pacmanImage = pacmanUpImage;
                    } else if (pacman.direction == 'D') {
                        pacmanImage = pacmanDownImage;
                    } else if (pacman.direction == 'L') {
                        pacmanImage = pacmanLeftImage;
                    } else if (pacman.direction == 'R') {
                        pacmanImage = pacmanRightImage;
                    }
                } else {
                    pacmanImage = pacmanClosedImage;
                }
                g.drawImage(pacmanImage, pacman.x, pacman.y, pacman.width, pacman.height, null);
            }
        }
        
        // Draw UI elements
        g.setFont(new Font("Arial", Font.BOLD, 16));
        
        // Always show score
        g.setColor(Color.WHITE);
        g.drawString("SCORE: " + score, 10, 20);
        g.drawString("HIGH SCORE: " + highScore, boardWidth - 150, 20);
        g.drawString("LEVEL: " + level, boardWidth / 2 - 30, 20);
        
        // Draw lives
        for (int i = 0; i < lives; i++) {
            g.drawImage(pacmanRightImage, 10 + i * 25, 30, 20, 20, null);
        }
        
        // Draw game state specific elements
        switch (currentState) {
            case STARTING:
            g.setFont(new Font("Arial", Font.BOLD, 48));
            g.setColor(Color.YELLOW);
            g.drawString("READY!", boardWidth / 2 - 80, boardHeight / 2);
            
            g.setFont(new Font("Arial", Font.BOLD, 36));
            g.drawString("" + startCountdown, boardWidth / 2 - 10, boardHeight / 2 + 50);
            break;
            case PAUSED:
            g.setFont(new Font("Arial", Font.BOLD, 48));
            g.setColor(Color.YELLOW);
            g.drawString("PAUSED", boardWidth / 2 - 80, boardHeight / 2);
            break;
            case GAME_OVER:
            g.setFont(new Font("Arial", Font.BOLD, 48));
            g.setColor(Color.RED);
            g.drawString("GAME OVER", boardWidth / 2 - 120, boardHeight / 2);
            
            g.setFont(new Font("Arial", Font.BOLD, 24));
            g.setColor(Color.YELLOW);
            g.drawString("Press SPACE to restart", boardWidth / 2 - 120, boardHeight / 2 + 50);
            break;
            case LEVEL_COMPLETE:
            g.setFont(new Font("Arial", Font.BOLD, 36));
            g.setColor(Color.GREEN);
            g.drawString("LEVEL " + (level-1) + " COMPLETE!", boardWidth / 2 - 150, boardHeight / 2);
            break;
        }
    }
    
    // Move all game elements and check for collisions.
    public void move() {
        // Handle Pac-Man movement
        pacman.x += pacman.velocityX;
        pacman.y += pacman.velocityY;
        
        // Handle teleportation tunnels
        if (pacman.x < -pacman.width) {
            pacman.x = boardWidth;
        } else if (pacman.x > boardWidth) {
            pacman.x = -pacman.width;
        }
        
        // Check wall collisions for Pac-Man
        for (Block wall : walls) {
            if (collision(pacman, wall)) {
                pacman.x -= pacman.velocityX;
                pacman.y -= pacman.velocityY;
                break;
            }
        }
        
        // Check food collisions
        Block foodEaten = null;
        for (Block food : foods) {
            if (collision(pacman, food)) {
                foodEaten = food;
                score += 10;
                if (score > highScore) {
                    highScore = score;
                }
                break;
            }
        }
        if (foodEaten != null) {
            foods.remove(foodEaten);
        }
        
        // Check power pellet collisions
        Block pelletEaten = null;
        for (Block pellet : powerPellets) {
            if (collision(pacman, pellet)) {
                pelletEaten = pellet;
                score += 50;
                if (score > highScore) {
                    highScore = score;
                }
                activatePowerMode();
                break;
            }
        }
        if (pelletEaten != null) {
            powerPellets.remove(pelletEaten);
        }
        
        // Update power mode timer
        if (isPowered) {
            poweredTimer--;
            if (poweredTimer <= 0) {
                deactivatePowerMode();
            }
        }
        
        // Move and check ghost collisions
        for (Ghost ghost : ghosts) {
            // Check for collision with Pac-Man
            if (collision(pacman, ghost)) {
                if (ghost.isFrightened) {
                    // Eat the ghost
                    ghost.reset();
                    score += 200;
                    if (score > highScore) {
                        highScore = score;
                    }
                } else {
                    // Player dies
                    lives--;
                    if (lives <= 0) {
                        currentState = GameState.GAME_OVER;
                    } else {
                        resetPositions();
                    }
                    return;
                }
            }
            
            // Move ghosts
            moveGhost(ghost);
        }
        
        // Check if level is complete
        if (foods.isEmpty() && powerPellets.isEmpty()) {
            currentState = GameState.LEVEL_COMPLETE;
            
            // Schedule next level after 3 seconds
            Timer levelTimer = new Timer(3000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    nextLevel();
                    ((Timer)e.getSource()).stop();
                }
            });
            levelTimer.setRepeats(false);
            levelTimer.start();
        }
        
        // Update animation counter
        animationCounter++;
    }
    
    // Move a ghost and handle its collisions and direction changes.
    
    private void moveGhost(Ghost ghost) {
        // Handle teleportation tunnels for ghosts
        if (ghost.x < -ghost.width) {
            ghost.x = boardWidth;
        } else if (ghost.x > boardWidth) {
            ghost.x = -ghost.width;
        }
        
        // Move ghost
        ghost.x += ghost.velocityX;
        ghost.y += ghost.velocityY;
        
        // Check wall collisions
        boolean needsNewDirection = false;
        for (Block wall : walls) {
            if (collision(ghost, wall)) {
                ghost.x -= ghost.velocityX;
                ghost.y -= ghost.velocityY;
                needsNewDirection = true;
                break;
            }
        }
        
        // Change direction if needed or randomly
        if (needsNewDirection || random.nextInt(100) < 5) {
            // Choose a new direction
            char newDirection;
            if (ghost.isFrightened) {
                // Frightened ghosts move randomly
                newDirection = directions[random.nextInt(4)];
            } else {
                // Normal ghosts try to target Pac-Man
                int dx = pacman.x - ghost.x;
                int dy = pacman.y - ghost.y;
                
                // Prioritize horizontal or vertical movement based on distance
                if (Math.abs(dx) > Math.abs(dy)) {
                    newDirection = dx > 0 ? 'R' : 'L';
                } else {
                    newDirection = dy > 0 ? 'D' : 'U';
                }
                
                // Sometimes choose random direction to avoid predictable patterns
                if (random.nextInt(100) < 30) {
                    newDirection = directions[random.nextInt(4)];
                }
            }
            
            ghost.updateDirection(newDirection);
        }
    }
    
    // Activate power mode when Pac-Man eats a power pellet.
    private void activatePowerMode() {
        isPowered = true;
        poweredTimer = 300; 
        
        for (Ghost ghost : ghosts) {
            ghost.setFrightened(true); // Set all ghosts to frightened state
        }
    }
    
    // Deactivate power mode when timer runs out.
    private void deactivatePowerMode() {
        isPowered = false;
        
        for (Ghost ghost : ghosts) {
            ghost.setFrightened(false); // Set all ghosts back to normal state
        }
    }
    
    // Advance to the next level.
    private void nextLevel() {
        level++;
        // Increase ghost speed with each level, up to a maximum
        baseGhostSpeed = Math.min(tileSize/2, baseGhostSpeed + tileSize/16);
        
        // Reset everything for next level
        loadMap();
        resetPositions();
        currentState = GameState.PLAYING;
    }
    
    /**
    * Check if two blocks collide.
    * a First block
    * b Second block
    * @return True if the blocks collide
    */
    public boolean collision(Block a, Block b) {
        return a.x < b.x + b.width &&
        a.x + a.width > b.x &&
        a.y < b.y + b.height &&
        a.y + a.height > b.y;
    }
    
    
    //Reset positions of Pac-Man and ghosts.
    public void resetPositions() {
        pacman.reset(); // Reset Pac-Man's position
        pacman.velocityX = 0;
        pacman.velocityY = 0;
        
        for (Ghost ghost : ghosts) {
            ghost.reset(); // Reset each ghost's position
            ghost.setFrightened(false); // Set ghosts back to normal state
            char newDirection = directions[random.nextInt(4)]; // Choose a random direction
            ghost.updateDirection(newDirection); // Update the ghost's direction
        }
        
        // Add a small pause before resuming
        currentState = GameState.STARTING;
        startCountdown();
    }
    
    // Restart the game from the beginning.
    public void restartGame() {
        score = 0; // Reset the score
        lives = 3; // Reset the number of lives
        level = 1; // Reset the level
        baseGhostSpeed = tileSize/4; // Reset the ghost speed
        
        loadMap(); // Reload the map
        resetPositions(); // Reset positions
        currentState = GameState.STARTING; // Set the game state to STARTING
        startCountdown(); // Start the countdown
    }
    
    // Process action events (game loop).
    @Override
    public void actionPerformed(ActionEvent e) {
        if (currentState == GameState.PLAYING) {
            move(); // Move game elements
        }
        repaint(); // Redraw the game panel
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }
    
    
    @Override
    public void keyPressed(KeyEvent e) {
    }
    
    //Process key released events.
    @Override
    public void keyReleased(KeyEvent e) {
        if (currentState == GameState.GAME_OVER) {
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                restartGame(); // Restart the game if SPACE is pressed
                gameLoop.start(); // Start the game loop
            }
            return;
        }
        
        if (currentState == GameState.PLAYING) {
            // Movement controls
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                pacman.updateDirection('U'); // Move Pac-Man up
            } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                pacman.updateDirection('D'); // Move Pac-Man down
            } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                pacman.updateDirection('L'); // Move Pac-Man left
            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                pacman.updateDirection('R'); // Move Pac-Man right
            }
            
            // Update Pac-Man image based on direction
            if (pacman.direction == 'U') {
                pacman.image = pacmanUpImage;
            } else if (pacman.direction == 'D') {
                pacman.image = pacmanDownImage;
            } else if (pacman.direction == 'L') {
                pacman.image = pacmanLeftImage;
            } else if (pacman.direction == 'R') {
                pacman.image = pacmanRightImage;
            }
            
            // Pause game
            if (e.getKeyCode() == KeyEvent.VK_P) {
                currentState = GameState.PAUSED; // Set the game state to PAUSED
                stopGameSound(); // Stop the game sound
                gameLoop.stop(); // Stop the game loop
            }
        } else if (currentState == GameState.PAUSED) {
            if (e.getKeyCode() == KeyEvent.VK_P) {
                currentState = GameState.PLAYING; // Set the game state to PLAYING
                playGameSound(); // Play the game sound
                gameLoop.start(); // Start the game loop
            }
        }
    }
    
    
    // Main method to start the game.
    public static void main(String[] args) {
        JFrame window = new JFrame("Pac-Man"); // Create the game window
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close the window on exit
        window.setResizable(false); // Disable window resizing
        
        PacMan game = new PacMan(); // Create the game instance
        window.add(game); // Add the game to the window
        window.pack(); // Pack the window to fit the game panel
        window.setLocationRelativeTo(null); // Center the window on the screen
        window.setVisible(true); // Make the window visible
    }
}