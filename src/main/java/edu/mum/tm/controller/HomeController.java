package edu.mum.tm.controller;

import edu.mum.tm.domain.Role;
import edu.mum.tm.domain.User;
import edu.mum.tm.service.RoleService;
import edu.mum.tm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    RoleService roleService;

    @RequestMapping(value={ "/"}, method = RequestMethod.GET)
    public String welcome( Model model) {

//        User user=userService.findUserByEmail("ehassan@mum.edu");
//        if(user==null)
//        {
//            user=new User();
//            user.setFirstName("Eman");
//            user.setLastName("Hassan");
//            user.setEmail("ehassan@mum.edu");
//            user.setPassword("123456");
//            user.setId(1);
//            user.setActive(1);
//            long id=1;
//            Role r=roleService.get(id);
//            Set<Role> rlist=new HashSet<>();
//            rlist.add(r);
//            user.setRoles(rlist);
//            userService.saveUser(user);
//        }
//        //for faculty
//
//        User user2=userService.findUserByEmail("atantawy@mum.edu");
//        if(user2==null)
//        {
//            user2=new User();
//            user2.setFirstName("Abdelrady");
//            user2.setLastName("Tantawy");
//            user2.setEmail("atantawy@mum.edu");
//            user2.setPassword("123456");
//            user2.setId(1);
//            user2.setActive(1);
//            long id=2;
//            Role r=roleService.get(id);
//            Set<Role> rlist=new HashSet<>();
//            rlist.add(r);
//            user2.setRoles(rlist);
//            userService.saveUser(user2);
//        }
//
//        //for student
//
//       User  user3=userService.findUserByEmail("student@mum.edu");
//        if(user3==null)
//        {
//           user3=new User();
//           user3.setFirstName("Ahmed");
//           user3.setLastName("Yassin");
//           user3.setEmail("student@mum.edu");
//           user3.setPassword("123456");
//           user3.setId(1);
//           user3.setActive(1);
//            long id=3;
//            Role r=roleService.get(id);
//            Set<Role> rlist=new HashSet<>();
//            rlist.add(r);
//            user3.setRoles(rlist);
//            userService.saveUser(user3);
//        }
//        User  user4=userService.findUserByEmail("student@mum.edu");
//
//        System.out.println(user4.getPassword());
        return "index";
    }

    @GetMapping("/checkRole")
    public String goToPage(HttpSession session)
    {
        System.out.println("inpage.....");

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        session.setAttribute("auhenticatedUser",user);
        if(user.isAdmin())
        {
            return "redirect:/admin/index";
        }
        else if(user.isFaculty())
        {
            return "redirect:/faculty/index";
        }
        else
        {
            return "redirect:/student/index";

        }
    }


}
