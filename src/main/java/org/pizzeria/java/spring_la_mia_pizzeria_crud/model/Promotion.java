package org.pizzeria.java.spring_la_mia_pizzeria_crud.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "promotions")
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Size(min = 5, max = 100, message = "Title must be between 5 and 100 characters")
    String title;

    @Past(message = "Start date cannot be in the past")
    LocalDate startDate;

    @Past(message = "End date cannot be in the past")
    LocalDate endDate;

    @NotBlank
    @Min(value = 1, message = "discount must be expressend in percentage, so it must be between 1 and 100")
    @Max(value = 100, message = "discount must be expressend in percentage, so it must be between 1 and 100")
    Integer discount;

    @ManyToOne
    @JoinColumn(name = "pizza_id", nullable = false)
    private Pizza pizza;

    public Promotion() {
    };

    public Promotion(String title, LocalDate starDate, LocalDate endDate, Integer discount) {
        this.title = title;
        this.startDate = starDate;
        this.endDate = endDate;
        this.discount = discount;
    };

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getStartDate() {
        return this.startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return this.endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Integer getDiscount() {
        return this.discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String toString() {
        return String.format("title: %s, discount: %d", getTitle(), getDiscount());
    }

}
