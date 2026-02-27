package com.codecrafthub.repository;

import com.codecrafthub.model.Course;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Repository class responsible for reading and writing courses to the JSON file.
 */
@Repository
public class CourseRepository {

    private static final String FILE_PATH = "courses.json"; // file stored in working directory

    private final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Retrieves all courses from the JSON file.
     * If the file doesn't exist, returns an empty list.
     *
     * @return List of all courses
     */
    public List<Course> findAll() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            // File doesn't exist yet, return empty list
            return new ArrayList<>();
        }

        try {
            // Read list of courses from JSON file
            return objectMapper.readValue(file, new TypeReference<List<Course>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            // On error, return empty list or consider throwing a custom exception
            return new ArrayList<>();
        }
    }

    /**
     * Saves the full list of courses to the JSON file.
     *
     * @param courses List of courses to save
     * @throws IOException if writing to file fails
     */
    public void saveAll(List<Course> courses) throws IOException {
        File file = new File(FILE_PATH);
        // Write list of courses to JSON file, pretty print for readability
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, courses);
    }

    /**
     * Finds a course by its ID.
     *
     * @param id Course ID
     * @return Optional containing the course if found, else empty
     */
    public Optional<Course> findById(int id) {
        return findAll().stream()
                .filter(course -> course.getId() == id)
                .findFirst();
    }
}
