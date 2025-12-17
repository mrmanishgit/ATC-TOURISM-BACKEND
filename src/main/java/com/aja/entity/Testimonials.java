package com.aja.entity;

<<<<<<< HEAD
=======
import java.time.LocalDateTime;

>>>>>>> aadfddf802f8e13860d6df475837000ec472afe1
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
<<<<<<< HEAD
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="test_monials")
=======
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
>>>>>>> aadfddf802f8e13860d6df475837000ec472afe1
public class Testimonials {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

<<<<<<< HEAD
	private String name;
	private String rating;
	private String review;
	private String image;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private Users user;
=======
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long testimonialId;

    private Integer rating;

    private String review;

    private LocalDateTime createdAt;

>>>>>>> aadfddf802f8e13860d6df475837000ec472afe1
}
