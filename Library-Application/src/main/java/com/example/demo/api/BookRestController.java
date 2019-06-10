package com.example.demo.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AuthorDto;
import com.example.demo.dto.BookDto;
import com.example.demo.dto.BookOneDto;
import com.example.demo.dto.BookUpdateDto;
import com.example.demo.service.imp.AuthorServiceImp;
import com.example.demo.service.imp.BookServiceImp;
import com.example.demo.util.ApiPaths;
import com.example.demo.util.TPage;

import javassist.NotFoundException;

@RestController
@RequestMapping(ApiPaths.BookCtrl.CTRL)
@CrossOrigin
public class BookRestController {
	
	private final AuthorServiceImp authorServiceImp;
	private final BookServiceImp bookServiceImp;
	
	public BookRestController(AuthorServiceImp authorServiceImp,
								BookServiceImp bookServiceImp) {
		super();
		this.authorServiceImp = authorServiceImp;
		this.bookServiceImp = bookServiceImp;
	}
	
	
    @GetMapping()
    public ResponseEntity<List<BookDto>> getAll() throws NotFoundException {
        return ResponseEntity.ok(bookServiceImp.getAll());
    }
    
	//localhost:8182/api/book/pagination?page=1&size=3
    @GetMapping("/pagination")
    public ResponseEntity<TPage<BookDto>> getAllByPagination(Pageable pageable) {
        TPage<BookDto> data = bookServiceImp.getAllPageable(pageable);
        return ResponseEntity.ok(data);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<BookOneDto> getAll(@PathVariable(name="id",required=true) Long id) throws NotFoundException {
        
        return ResponseEntity.ok(bookServiceImp.getOne(id));
    }

	@PostMapping()
	public ResponseEntity<BookDto> createProject(@Valid @RequestBody BookDto bookDto){
		return ResponseEntity.ok(bookServiceImp.save(bookDto));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<BookUpdateDto> updateBook(@PathVariable(name="id",required=true) Long id,
													@Valid @RequestBody BookUpdateDto bookUpdateDto){
		return ResponseEntity.ok(bookServiceImp.update(id, bookUpdateDto));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteBook(@PathVariable(name="id", required=true) Long id) throws NotFoundException {
		return ResponseEntity.ok(bookServiceImp.delete(id));
	}
}