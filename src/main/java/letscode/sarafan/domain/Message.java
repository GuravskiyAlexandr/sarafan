package letscode.sarafan.domain;


import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table()
@ToString(of = {"id", "text"})
@EqualsAndHashCode(of = {"id"})
@Data
////предовращает циклическую зависимость ----- JsonIdentityInfo
////com.fasterxml.jackson.databind.JsonMappingException:
////        Infinite recursion (StackOverflowError)
//@JsonIdentityInfo(
//        property = "id",
//        generator = ObjectIdGenerators.PropertyGenerator.class
//)

@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class)

public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView(Views.Id.class)
    private Long id;
    @JsonView(Views.IdName.class)
    private String text;

    @Column(updatable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonView(Views.FullMessage.class)
    private LocalDateTime creationDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonView(Views.IdName.class)
    private User author;

    @OneToMany(mappedBy = "message", orphanRemoval = true)
    @JsonView(Views.IdName.class)
    private List<Comment> comments;


    @JsonView(Views.FullMessage.class)
    @Column(length = 1000)
    private String link;
    @JsonView(Views.FullMessage.class)
    @Column(length = 1000)
    private String linkTitle;
    @JsonView(Views.FullMessage.class)
    @Column(length = 1000)
    private String linkDescription;
    @Column(length = 1000)
    @JsonView(Views.FullMessage.class)
    private String linkCover;
}



//
//import com.fasterxml.jackson.annotation.*;
//
//
//import com.fasterxml.jackson.annotation.ObjectIdGenerators;
//
//
//import javax.persistence.*;
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.Objects;
//
//@Entity
//@Table
////@EqualsAndHashCode(of = {"id"})
//
////предовращает циклическую зависимость ----- JsonIdentityInfo
////com.fasterxml.jackson.databind.JsonMappingException:
////        Infinite recursion (StackOverflowError)
//@JsonIdentityInfo(
//        property = "text",
//        generator = ObjectIdGenerators.PropertyGenerator.class
//)
//public class Message {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @JsonView(Views.Id.class)
//    Long id;
//    @JsonView(Views.IdName.class)
//    @Column(length = 1000)
//    String text;
//
//    @Column(updatable = false)
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
//    @JsonView(Views.Time.class)
//    private LocalDateTime createDate;
//
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    @JsonView(Views.IdName.class)
//    private User author;
//
//    //если сообщение удаляется все зависимые комменты удаляются тоже  orphanRemoval = true
//    @OneToMany(mappedBy = "message", orphanRemoval = true)
//    @JsonView(Views.FullMessage.class)
//    private List<Comment> comments;
//
//
//    @JsonView(Views.FullMessage.class)
//    @Column(length = 1000)
//    private String link;
//    @JsonView(Views.FullMessage.class)
//    @Column(length = 1000)
//    private String linkTitle;
//    @JsonView(Views.FullMessage.class)
//    @Column(length = 1000)
//    private String linkDescription;
//    @Column(length = 1000)
//    @JsonView(Views.FullMessage.class)
//    private String linkCover;
//
//    public Message() {
//    }
//
//    public Message(Long id) {
//        this.id = id;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getText() {
//        return text;
//    }
//
//    public void setText(String text) {
//        this.text = text;
//    }
//
//    public LocalDateTime getCreateDate() {
//        return createDate;
//    }
//
//    public void setCreateDate(LocalDateTime createDate) {
//        this.createDate = createDate;
//    }
//
//    public String getLink() {
//        return link;
//    }
//
//    public void setLink(String link) {
//        this.link = link;
//    }
//
//    public String getLinkTitle() {
//        return linkTitle;
//    }
//
//    public void setLinkTitle(String linkTitle) {
//        this.linkTitle = linkTitle;
//    }
//
//    public String getLinkDescription() {
//        return linkDescription;
//    }
//
//    public void setLinkDescription(String linkDescription) {
//        this.linkDescription = linkDescription;
//    }
//
//    public String getLinkCover() {
//        return linkCover;
//    }
//
//    public void setLinkCover(String linkCover) {
//        this.linkCover = linkCover;
//    }
//
//    public User getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(User author) {
//        this.author = author;
//    }
//
//    public List<Comment> getComments() {
//        return comments;
//    }
//
//    public void setComments(List<Comment> comments) {
//        this.comments = comments;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Message message = (Message) o;
//        return Objects.equals(id, message.id);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id);
//    }
//
//    @Override
//    public String toString() {
//        return "Message{" +
//                "id=" + id +
//                ", text='" + text + '\'' +
//                '}';
//    }
//}
//
//
