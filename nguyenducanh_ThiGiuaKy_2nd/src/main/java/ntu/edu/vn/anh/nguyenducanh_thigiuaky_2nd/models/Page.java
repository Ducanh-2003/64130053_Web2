package ntu.edu.vn.anh.nguyenducanh_thigiuaky_2nd.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Page {
    private String id;
    private String pageName;
    private String keyword;
    private String content;
    private String parentPageId;

    public Page() {}

    public Page(String id, String pageName, String keyword, String content, String parentPageId) {
        this.id = id;
        this.pageName = pageName;
        this.keyword = keyword;
        this.content = content;
        this.parentPageId = parentPageId;
    }


}
