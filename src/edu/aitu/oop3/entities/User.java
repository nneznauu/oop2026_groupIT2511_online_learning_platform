package edu.aitu.oop3.entities;

public class User {
    private int id;
    private String name;
    private String email;
    private String role; // student / instructor

    public User(String name, String email, String role) {
        this.name = name;
        this.email = email;
        this.role = role;
    }

    public User(int id, String name, String email, String role) {
        this(name, email, role);
        this.id = id;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getRole() { return role; }

    @Override
    public String toString() {
        return String.format("User[ID: %d, Name: %s, Email: %s, Role: %s]", id, name, email, role);
    }
}