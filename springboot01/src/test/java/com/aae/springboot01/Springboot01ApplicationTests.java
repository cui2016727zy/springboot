package com.aae.springboot01;

import com.aae.springboot01.dao.BookDao;
import com.aae.springboot01.pojo.Book;
import com.aae.springboot01.service.IBookService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot01ApplicationTests {

    @Autowired
    private BookDao bookDao;

    @Autowired
    private IBookService bookService;

    @Test
    void contextLoads() {
        System.out.println(bookDao.selectById(1));
    }
    @Test
    void test(){
        Book book = new Book();
        book.setType("测试数据");
        book.setName("测试数据");
        book.setDescription("123");
        bookService.save(book);
    }

    @Test
    void testPage(){
        IPage page=new Page(2,5);
        bookDao.selectPage(page,null);
    }

    @Test
    void testGetBy(){
//        QueryWrapper<Book> queryWrapper=new QueryWrapper();
//        queryWrapper.like("name","java");
//        bookDao.selectList(queryWrapper);
        LambdaQueryWrapper<Book> lambdaQueryWrapper=new LambdaQueryWrapper();
        lambdaQueryWrapper.like(Book::getName,"java");
        bookDao.selectList(lambdaQueryWrapper);
    }

    @Test
    void testupdate(){
        Book book=new Book();
        book.setId(19);
        book.setName("sada");
        book.setType("123");
        book.setDescription("456");
        bookService.update(book,null);
    }
}
