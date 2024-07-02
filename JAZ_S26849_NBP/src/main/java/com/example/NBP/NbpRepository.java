package com.example.NBP;


import com.example.NBP.Models.GoldValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NbpRepository extends JpaRepository<GoldValue, Integer>
{
}
