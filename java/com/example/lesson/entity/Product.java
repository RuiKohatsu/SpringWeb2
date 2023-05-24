package com.example.lesson.entity;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
@Data
public class Product {
    @NotEmpty()
    @Length(min = 1, max = 50)
    public String name;
    @NotEmpty(message = "値段は必須入力です")
    @Min(value = 0)
    @Pattern(regexp = "^[0-9]+$")
    public String price;

}
