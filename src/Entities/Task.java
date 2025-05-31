package Entities;

import Entities.Enums.Status;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Random;

public class Task {
    private long id;
    private String description;
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Task(String description) {
        this.id = new Random().nextLong(1_000_000);
        this.description = description;
        this.status = Status.IN_PROGRESS;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "{\n" +
                "    \"id\": " + id + ",\n" +
                "    \"description\": \"" + description + "\",\n" +
                "    \"status\": \"" + status + "\",\n" +
                "    \"createdAt\": \"" + createdAt + "\",\n" +
                "    \"updatedAt\": \"" + updatedAt + "\"\n" +
                "   }";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
