package com.tlcomunic.aut.dto;

import com.tlcomunic.aut.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateRoleInput {

	private Role role;
}
