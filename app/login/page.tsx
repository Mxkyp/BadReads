"use client";

import React from "react";
import { Input } from "@/components/ui/input";
import { Button } from "@/components/ui/button";
import { motion } from "framer-motion";

export default function LoginPage() {
  return (
    <div className="min-h-screen bg-gray-100 flex items-center justify-center p-4">
      <motion.div
        initial={{ opacity: 0, y: -20 }}
        animate={{ opacity: 1, y: 0 }}
        className="bg-white shadow-lg rounded-xl p-8 w-full max-w-md"
      >
        <h2 className="text-2xl font-bold text-center text-green-800 mb-6">
          Sign in
        </h2>
        <form className="flex flex-col gap-4">
          <Input type="email" placeholder="Email" required />
          <Input type="password" placeholder="Password" required />
        <motion.button
          whileHover={{ scale: 1.02 }}
          className="bg-green-700 text-white font-medium px-4 py-2 rounded-lg shadow hover:bg-green-800 transition-colors"
        >
          Login
        </motion.button>
        </form>
      </motion.div>
    </div>
  );
}
