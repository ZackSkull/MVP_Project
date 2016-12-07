<?php

use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class CreateUsersTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('users', function (Blueprint $table) {
            $table->increments('userId');
			$table->string('userUsername');
			$table->string('userPassword', 60);
			$table->string('userName');
			$table->tinyInteger('gender');
			$table->string('userBornPlace');
			$table->string('userBornDate');
			$table->string('userCity');
			$table->string('userAddress');
			$table->string('userPhone');
			$table->string('userEmail')->unique();
			$table->string('userBio');
			$table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::drop('users');
    }
}
