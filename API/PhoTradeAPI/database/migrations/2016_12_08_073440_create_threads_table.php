<?php

use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class CreateThreadsTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('threads', function (Blueprint $table) {
            $table->increments('trId');
            $table->integer('trProdId');
            $table->integer('trUser');
            $table->integer('trUserBuy')->nullable()->default(0);
            $table->boolean('trStatus');
            $table->string('trLat');
            $table->string('trLong');
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
        Schema::drop('threads');
    }
}
