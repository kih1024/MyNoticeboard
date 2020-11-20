package com.kih.board.springboot.web;

import com.kih.board.springboot.config.auth.LoginUser;
import com.kih.board.springboot.config.auth.dto.SessionUser;
import com.kih.board.springboot.service.posts.PostsService;
import com.kih.board.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {

        model.addAttribute("posts", postsService.findAllDesc());
        // 이제 이렇게 일일히 httpSession.getAttribute("user");을 호출할 필요 없다. 왜냐면 @LoingUser 가 있기 때문에.
        // WebMvcConfigurer의 구현체에서 HandlerMethodArgumentResolver의 구현체(LoginuserArgumentResolver)를 등록해 @LoingUser에 기능을 부여했다.
        // 이렇게하면 여러 컨트롤러에서 아래와 같은 코드를 반복해서 쓸 필요가 없다.
//         SessionUser user = (SessionUser) httpSession.getAttribute("user");
//        System.out.println(user.getName());
        System.out.println(user);
        if (user != null) {
            model.addAttribute("name", user.getName());
        }

        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {

        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }

}
