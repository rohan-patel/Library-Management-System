package com.rohan.lms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rohan.lms.repository.MemberRepository;

@RestController
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberRepository memberRepo;
	
	/* 
	 * GET - get all members
	 * GET - get a member by id
	 * POST - add a member
	 * PUT - update a member by id
	 * DELETE - remove a member by id
	 *  */
	
}
