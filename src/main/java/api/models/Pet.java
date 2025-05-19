package api.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pet {
    private Integer id;
    private String name;
    @Builder.Default
    private Category category = new Category(1, "default_category_0");
    @Builder.Default
    private List<String> photoUrls = List.of("url_0", "url_1");
    @Builder.Default
    private List<Tag> tags = List.of(new Tag(0, "default_tag_0"), new Tag(1, "default_tag_1"));
    @Builder.Default
    private String status = Status.AVAILABLE.toString().toLowerCase();
}
