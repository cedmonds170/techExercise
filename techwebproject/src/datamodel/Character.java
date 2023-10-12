package datamodel;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "characterTable")
public class Character {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
   private Integer id;

   @Column(name = "name")
   private String name;

   @Column(name = "level")
   private Integer level;
   
   //
   @Column(name = "job")
   private String job;
   //

   public Character() {
   }

   public Character(Integer id, String name, Integer age, String phone) {
      this.id = id;
      this.name = name;
      this.level = age;
      //
      this.job = phone;
      //
   }

   public Character(String name, int age, String phone) {
      this.name = name;
      this.level = age;
      this.job = phone;
   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public Integer getLevel() {
      return level;
   }

   public void setLevel(Integer level) {
      this.level = level;
   }
   public String getJob() {
	      return job;
   }

   public void setJob(String job) {
      this.job = job;
   }

   @Override
   public String toString() {
      return "Character: " + this.id + ", " + this.name + ", " + this.level + ","+this.job;
   }
}