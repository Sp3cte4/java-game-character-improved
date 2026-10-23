# Fantasy Arena - Java Game Character

## Project Description

Fantasy Arena is an improved Java Game Character application built using Java Swing. It allows users to create and manage different fantasy characters, view their health, and display their unique abilities through an interactive graphical interface.

The project demonstrates object-oriented programming, abstraction, an Abstract Data Type (ADT), graphical user interfaces, and user input validation.

## Features

- **Character Creation:** Create new characters by entering a name and selecting a character class.
- **Multiple Character Classes:** Includes Warrior, Mage, Paladin, Assassin, and Archer, each with its own abilities and behavior.
- **Character Management:** View the character roster, select characters, update character names, and remove characters.
- **Character Abilities:** Use the Attack, Passive, and Ultimate buttons to display each character's abilities in the battle log.
- **Health Display:** View a character's current health and health percentage.
- **Input Validation:** Prevents empty names, duplicate names, names longer than 20 characters, and unsupported characters in names.
- **Custom GUI:** Features a dark fantasy theme, colored buttons, character status panels, and a battle log.

## Concepts Demonstrated

### 1. Abstraction

The abstract class `Game_Character` defines common properties and behaviors shared by all characters. It contains abstract methods such as `attack()`, `passive()`, and `ultimate()`.

The subclasses `Warrior`, `Mage`, `Paladin`, `Assassin`, and `Archer` implement these methods according to their own abilities.

### 2. Abstract Data Type (ADT)

The `CharacterManager` class manages the game's characters using a Java `List` backed by an `ArrayList`.

It provides methods to add, find, remove, and retrieve characters. This keeps character management separate from the graphical interface.

### 3. Graphical User Interface (GUI)

The application uses Java Swing components, including `JFrame`, `JPanel`, `JList`, `JComboBox`, `JButton`, `JLabel`, `JProgressBar`, and `JTextArea`.

These components provide the character creator, roster, health display, ability controls, and battle log.

### 4. User Input

Users enter character names through a text field, select character classes from a dropdown, and interact with buttons to manage characters and use abilities.

The application validates names and checks for duplicate characters before creating or updating a character.

## Technologies Used

- Java
- Java Swing
- Object-Oriented Programming
- Eclipse IDE
- Git and GitHub

## How to Run the Program

1. Download or clone this repository.
2. Open Eclipse IDE.
3. Import the project using **File → Import → Existing Projects into Workspace**.
4. Select the downloaded project folder and finish importing.
5. Open `src/gamecharacter/Main.java`.
6. Right-click `Main.java` and select **Run As → Java Application**.
7. The Fantasy Arena window should open.

A compatible Java Development Kit (JDK) must be installed.

## Project Structure

```text
java-game-character/
├── src/
│   └── gamecharacter/
│       ├── Main.java
│       ├── GameGUI.java
│       ├── Game_Character.java
│       ├── CharacterManager.java
│       ├── Warrior.java
│       ├── Mage.java
│       ├── Paladin.java
│       ├── Assassin.java
│       └── Archer.java
└── README.md
```

## Author

Developed as an enhancement of the Java Game Character project for an academic programming assignment.


Created by: Jon Marl Kane L. Sartiga