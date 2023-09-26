package hanium.englishfairytale.tale.domain;

import hanium.englishfairytale.tale.domain.factory.CreatedTale;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Tale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "title", length = 100)
    private String title;
    @Column(name = "content", length = 5000)
    private String engTale;
    @Column(name = "kor",length = 3000)
    private String korTale;
    @Embedded
    private Image image;
    @Column(name = "created_date")
    private LocalDateTime createdTime;

    @OneToMany(mappedBy = "tale")
    private List<TaleKeyword> taleKeywords = new ArrayList<>();

    @Builder
    public Tale(String title, String engTale, String korTale) {
        this.title = title;
        this.engTale = engTale;
        this.korTale = korTale;
        this.image = new Image();
        this.createdTime = LocalDateTime.now();
    }

    public void putImage(TaleImage taleImage) {
        image.putTaleImage(taleImage);
    }

    public void addTaleKeyword(TaleKeyword newTaleKeyword) {
        this.taleKeywords.add(newTaleKeyword);
    }

}
