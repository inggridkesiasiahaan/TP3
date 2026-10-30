package com.unpri.charactermanager.model;

public class Character {
    private String name;
    private CharacterType type;
    private int level;
    private int hitPoints;
    private int attackPower;
    private int mana; // Ekstensi Bagian B: Atribut baru mana

    // Constructor 1: Default
    public Character() {
        this.name = "Unknown";
        this.type = CharacterType.WARRIOR;
        this.level = 1;
        this.hitPoints = 100;
        this.attackPower = 15;
        this.mana = 50;
    }

    // Constructor 2: Parameterized
    public Character(String name, CharacterType type, int level, int hitPoints, int attackPower, int mana) {
        this.name = name;
        this.type = type;
        this.level = level;
        this.hitPoints = hitPoints;
        this.attackPower = attackPower;
        setMana(mana); // Menggunakan setter agar validasi negatif berjalan
    }

    // Getter dan Setter untuk Name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter dan Setter untuk Type
    public CharacterType getType() {
        return type;
    }

    public void setType(CharacterType type) {
        this.type = type;
    }

    // Getter dan Setter untuk Level
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    // Getter dan Setter untuk HitPoints
    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    // Getter dan Setter untuk AttackPower
    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    // Ekstensi Bagian B: Getter getMana()
    public int getMana() {
        return mana;
    }

    // Ekstensi Bagian B: Setter setMana(int mana) dengan validasi
    public void setMana(int mana) {
        if (mana < 0) {
            throw new IllegalArgumentException("Mana tidak boleh bernilai negatif!");
        }
        this.mana = mana;
    }

    // Ekstensi Bagian B: Method isAlive()
    public boolean isAlive() {
        return hitPoints > 0;
    }

    // Method tambahan untuk demo level up
    public void levelUp() {
        this.level++;
        this.hitPoints += 20;
        this.attackPower += 5;
        this.mana += 15;
    }

    // toString() diperbarui untuk menampilkan mana (Bagian A & B)
    @Override
    public String toString() {
        return "Character [Name=" + name + ", Type=" + type + ", Level=" + level + 
               ", HP=" + hitPoints + ", Attack=" + attackPower + ", Mana=" + mana + 
               ", Alive=" + isAlive() + "]";
    }
}