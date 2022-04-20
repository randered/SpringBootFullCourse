package sfvpetclinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Pet {
    private PetType petType;
    private Owner owner;
    private LocalDate birthDate;
}
