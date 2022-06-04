package com.one.githubusers

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.one.githubusers.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val list = ArrayList<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.elevation = 0f

        binding.rvUsers.setHasFixedSize(true)

        list.addAll(getListUsers())
        showRecyclerView()
    }

    private fun getListUsers(): ArrayList<User>{
        val dataUsername = resources.getStringArray(R.array.username)
        val dataName = resources.getStringArray(R.array.name)
        val dataAvatar = resources.obtainTypedArray(R.array.avatar)
        val dataCompany = resources.getStringArray(R.array.company)
        val dataLocation = resources.getStringArray(R.array.location)
        val dataRepository = resources.getStringArray(R.array.repository)
        val dataFollowers = resources.getStringArray(R.array.followers)
        val dataFollowing = resources.getStringArray(R.array.following)

        val listUser = ArrayList<User>()

        for (i in dataName.indices) {
            val user = User(
                dataUsername[i],
                dataName[i],
                dataAvatar.getResourceId(i, -1),
                dataCompany[i],
                dataLocation[i],
                dataRepository[i],
                dataFollowers[i],
                dataFollowing[i]
            )
            listUser.add(user)
        }

        return listUser
    }

    private fun showRecyclerView() {
        binding.rvUsers.layoutManager = LinearLayoutManager(this)
        val userAdapter = UserAdapter(list)
        binding.rvUsers.adapter = userAdapter

        userAdapter.setOnItemClickCallback(object: UserAdapter.OnItemClickCallback {
            override fun onItemClicked(data: User) {
                showSelectedUser(data)
            }
        })
    }

    private fun showSelectedUser(user: User){
        val moveDetail = Intent(this, DetailActivity::class.java)
        moveDetail.putExtra(K.DETAIL_EXTRA, user)
        startActivity(moveDetail)
    }
}