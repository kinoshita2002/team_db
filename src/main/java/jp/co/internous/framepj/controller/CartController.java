package jp.co.internous.framepj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import jp.co.internous.framepj.model.domain.TblCart;
import jp.co.internous.framepj.model.domain.dto.CartDto;
import jp.co.internous.framepj.model.form.CartForm;
import jp.co.internous.framepj.model.mapper.TblCartMapper;
import jp.co.internous.framepj.model.session.LoginSession;


/**
 * カート情報に関する処理のコントローラー
 * @author インターノウス
 *
 */
@Controller
@RequestMapping("/frameweb/cart")
public class CartController {
	
	@Autowired
	private TblCartMapper tblCartMapper;
	
	@Autowired
	private LoginSession loginSession;

	private Gson gson = new Gson();
	

	/**
	 * カート画面を初期表示する。
	 * @param m 画面表示用オブジェクト
	 * @return カート画面
	 */
	@RequestMapping("/")
	public String index(Model m) {

		int userId = loginSession.isLoggedIn() ? loginSession.getUserId() : loginSession.getTmpUserId();
		
		List<CartDto>carts = tblCartMapper.findByUserId(userId);
		
		m.addAttribute("carts",carts);
		m.addAttribute("loginSession",loginSession);
		
		return "cart";
	}

	/**
	 * カートに追加処理を行う
	 * @param f カート情報のForm
	 * @param m 画面表示用オブジェクト
	 * @return カート画面
	 */
	@RequestMapping("/add")
	public String addCart(CartForm f, Model m) {

		int userId = loginSession.isLoggedIn() ? loginSession.getUserId() : loginSession.getTmpUserId();
		
		f.setUserId(userId);
		
		TblCart c = new TblCart();
		c.setUserId(userId);
		c.setProductId(f.getProductId());
		c.setProductCount(f.getProductCount());
		
		int result = 0;
		if (tblCartMapper.findCountByUserIdAndProductId(userId,f.getProductId()) > 0) {
			result = tblCartMapper.update(c);
		} else {
			result = tblCartMapper.insert(c);
		}
		if (result > 0) {
			List<CartDto> carts = tblCartMapper.findByUserId(userId);
			m.addAttribute("loginSession",loginSession);
			m.addAttribute("carts",carts);
		}
		
		return "redirect:/frameweb/cart/";
	}

	/**
	 * カート情報を削除する
	 * @param checkedIdList 選択したカート情報のIDリスト
	 * @return true:削除成功、false:削除失敗
	 */
	@PostMapping("/delete")
	@ResponseBody
	public boolean deleteCart(@RequestBody String checkedIdList) {

		int result = 0;
		
		CartForm form = gson.fromJson(checkedIdList,CartForm.class);
		
		result = tblCartMapper.deleteById(form.getCheckedIdList());
		
		return result == form.getCheckedIdList().size();
	}
}
