package boot.mapperIn;


import boot.myclasses.Book;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface Mapper001 extends BaseMapper<Book> {


    @Select("select * from books where id=#{id}")
    public Book getBookById(int id);

    @Insert(" insert into books (name,price,author) values(#{name},#{price},#{author})")
    @Options(useGeneratedKeys=true,keyProperty="id")
    public void insertBook(Book book);




}
