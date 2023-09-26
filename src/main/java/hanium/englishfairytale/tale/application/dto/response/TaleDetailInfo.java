package hanium.englishfairytale.tale.application.dto.response;

import hanium.englishfairytale.tale.domain.Keyword;
import hanium.englishfairytale.tale.domain.Tale;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TaleDetailInfo {
    private Long taleId;
    private String title;
    private String content;
    private String kor;
    private List<String> keywords;
    private String imgUrl;

    public TaleDetailInfo(Tale tale, List<Keyword> newKeywords, String imgUrl) {
        this.taleId = tale.getId();
        this.title = tale.getTitle();
        this.content = tale.getEngTale();
        this.kor = tale.getKorTale();
        this.imgUrl = imgUrl;

        keywords = new ArrayList<>();
        for(Keyword keyword:newKeywords) {
            this.keywords.add(keyword.getWord());
        }
    }
}
