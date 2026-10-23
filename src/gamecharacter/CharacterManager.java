package gamecharacter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CharacterManager {

    private final List<Game_Character> characters;

    public CharacterManager() {
        characters = new ArrayList<>();
    }

    // Add a character to the roster.
    public boolean addCharacter(Game_Character character) {
        if (character == null) {
            return false;
        }

        for (Game_Character existing : characters) {
            if (existing.getName().equalsIgnoreCase(character.getName())) {
                return false;
            }
        }

        characters.add(character);
        return true;
    }

    // Remove a character from the roster.
    public boolean removeCharacter(String name) {
        if (name == null || name.trim().isEmpty()) {
            return false;
        }

        for (int i = 0; i < characters.size(); i++) {
            if (characters.get(i).getName().equalsIgnoreCase(name.trim())) {
                characters.remove(i);
                return true;
            }
        }

        return false;
    }

    // Find a character by name.
    public Game_Character findCharacter(String name) {
        if (name == null) {
            return null;
        }

        for (Game_Character character : characters) {
            if (character.getName().equalsIgnoreCase(name.trim())) {
                return character;
            }
        }

        return null;
    }

    // Return a read-only view of the character roster.
    public List<Game_Character> getCharacters() {
        return Collections.unmodifiableList(characters);
    }

    public int getCharacterCount() {
        return characters.size();
    }

    public boolean isEmpty() {
        return characters.isEmpty();
    }
}