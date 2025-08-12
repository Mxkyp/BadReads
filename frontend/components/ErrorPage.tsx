"use client";

import React from "react";
import { motion } from "framer-motion";
import { Button } from "@/components/ui/button";

export default function ErrorPage({ code, message }) {
  return (
    <div className="min-h-screen bg-gray-100 flex flex-col items-center justify-center text-center p-6">
      <motion.h1
        className="text-[8rem] font-bold text-red-600"
        initial={{ scale: 0.5, opacity: 0 }}
        animate={{ scale: 1, opacity: 1 }}
        transition={{ duration: 0.4 }}
      >
        {code}
      </motion.h1>
      <p className="text-lg text-gray-700 mb-4 italic">{message}</p>
      <p className="text-sm text-gray-500 mb-8">
        Even our books are confused right now 📚🤯
      </p>
      <Button onClick={() => window.location.href = "/"}>🏠 Back to Home</Button>
    </div>
  );
}
