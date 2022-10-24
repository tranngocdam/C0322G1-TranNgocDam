package com.sprint2.repository;

import com.sprint2.model.Book;
import com.sprint2.model.Category;
import com.sprint2.model.Company;
import com.sprint2.model.Discount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

public interface IBookRepository extends JpaRepository<Book, Integer> {

    @Query(value = "select * " +
            "from book " +
            "where `name` like %:keyword% " +
            "and status = 0 " +
            "order by id desc",
            nativeQuery = true)
    Page<Book> findAllBook(Pageable pageable, @Param("keyword") String keyword);

    @Transactional
    @Modifying// cho phép thay đổi dữ liệu
    @Query(value = "update book set status = 1 where id =:id", nativeQuery = true)
    void delete(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "insert into book(amount, author, code, create_date, description, status, image, `name`, number_of_page, price, `size`, category_id, company_id, discount_id)" +
            "value (:amount, :author, :code, :createDate, :description, 0, :image, :name, :numberOfPage, :price, :size, :category, :company, :discount)", nativeQuery = true)
    void saveBook(@Param("amount") Integer amount,
                  @Param("author") String author,
                  @Param("code") String code,
                  @Param("createDate") LocalDate createDate,
                  @Param("description") String description,
                  @Param("image") String image,
                  @Param("name") String name,
                  @Param("numberOfPage") Integer numberOfPage,
                  @Param("price") Double price,
                  @Param("size") String size,
                  @Param("category") Category category,
                  @Param("company") Company company,
                  @Param("discount") Discount discount);

    @Modifying
    @Transactional
    @Query(value = "update book set amount = :amount, author = :author, code = :code, " +
            "create_date = :createDate, description = :description, image = :image, `name` = :name, " +
            "number_of_page = :numberOfPage, price = :price, `size` = :size, category_id = :category, " +
            "company_id = :company, discount_id = :discount where id = :id", nativeQuery = true)
    void updateBook(@Param("amount") Integer amount,
                    @Param("author") String author,
                    @Param("code") String code,
                    @Param("createDate") LocalDate createDate,
                    @Param("description") String description,
                    @Param("image") String image,
                    @Param("name") String name,
                    @Param("numberOfPage") Integer numberOfPage,
                    @Param("price") Double price,
                    @Param("size") String size,
                    @Param("category") Category category,
                    @Param("company") Company company,
                    @Param("discount") Discount discount,
                    @Param("id") Integer id);

    @Query(value = "select * from book where id = :id", nativeQuery = true)
    Book findByIdBook(@Param("id") Integer id);

    @Query(value = "select b.*, ob.customer_id from book b " +
            "join order_book ob on ob.book_id = b.id " +
            "where ob.customer_id = :id", nativeQuery = true)
    Page<Book> findAllHistoryBook(Pageable pageable, @Param("id") Integer id);

}
