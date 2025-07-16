package java_web.ss06bt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductPagination {
    private List<Product> products;
    private int totalPage;
    private int pageSize;
    private int currentPage;
}
