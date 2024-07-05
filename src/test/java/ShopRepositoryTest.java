import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {
    Product product1 = new Product(1, "Хлеб", 39);
    Product product2 = new Product(45, "Шоколад", 109);

    @Test
    public void removeProduct() {
        ShopRepository remove = new ShopRepository();

        remove.add(product1);
        remove.add(product2);
        remove.removeById(product2.getId());

        Product[] expected = {product1};
        Product[] actual = remove.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeNonExistentProduct() {
        ShopRepository remove = new ShopRepository();

        remove.add(product2);
        remove.add(product1);


        Assertions.assertThrows(NotFoundException.class, () -> {
            remove.removeById(7);
        });
    }
}