package dev.leonwong.youtubenoteserver.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "notes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Note {
    @JsonProperty("id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @JsonProperty("description")
    @Column(name = "description")
    private String description;

    @JsonProperty("title")
    @Column(name = "title")
    private String title;

    @JsonProperty("userId")
    @Column(name = "userId")
    private String userId;

    @JsonProperty("url")
    @Column(name = "url")
    private String url;

    @JsonProperty("content")
    @Column(name = "content",columnDefinition="TEXT")
    private String content;

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", title='" + title + '\'' +
                ", userId='" + userId + '\'' +
                ", url='" + url + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
